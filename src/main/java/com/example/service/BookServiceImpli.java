package com.example.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Dao.BookRepository;
import com.example.Model.Books;


@Service
public class BookServiceImpli implements BookService
{
	@Autowired
	private BookRepository repo;
	
	@Override
	public String saveData(Books book) 
	{
		 repo.save(book);
		 return "data saved";
	}
	
	@Override
	public List<Books> getAllBooks() 
	{
		
		return repo.findAll();
	}
	
	@Override
	public Books getBookByid(int bid)
	{
	
		Optional<Books> id = repo.findById(bid);
		Books b=id.get();
		return b;
	}
	
	@GetMapping("/getbyName/{bname}")
	public Books getbyName(@PathVariable String bname)
	{
		Books books = repo.findByBname(bname);
		return books;
	}
	
	
	
	@Override
	public Books getBookByIdAndIssuer(int bid, String bissuer) 
	{
	return repo.findByBidAndBissuer(bid,bissuer);
	}
	
	@Override
	public String updateData(Books b) 
	{
		Books save = repo.save(b);
		return "data updated";
	}
	
	@Override
	public String delete(int bid) 
	{
		repo.deleteById(bid);
		
	return "data deleted";

		
	}
	
}