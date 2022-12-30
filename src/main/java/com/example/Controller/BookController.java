package com.example.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Books;
import com.example.service.BookService;

@RestController
@RequestMapping("/BookController")
public class BookController 
{
	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public void check()
	{
		System.out.println("working");
			System.out.println("new changes");
	}

	@PostMapping("/saveBook")
	public ResponseEntity<String> saveData(@RequestBody Books book)
	{
		String save=service.saveData(book);
		return new ResponseEntity<String>(save,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Books>> getAllBooks()
	{
		List<Books> s=service.getAllBooks();
		return new ResponseEntity<List<Books>>(s,HttpStatus.OK);
	}
	
	@GetMapping("/getBookByid/{bid}")
	public ResponseEntity<Books>getBookByid(@PathVariable int bid)
	{
		Books b = service.getBookByid(bid);
		return new ResponseEntity<Books>(b,HttpStatus.OK);
		
	}
	
	@GetMapping("/getBookByName/{bname}")
	public ResponseEntity<Books>getBookByName(@PathVariable String bname)
	{
		Books name = service.getbyName(bname);
		return new ResponseEntity<Books>(name,HttpStatus.OK);
	}
	
	@GetMapping("/getBookByIdAndIssuer/{bid}/{bissuer}")
	public ResponseEntity<Books>getBookByIdAndIssuer(@PathVariable int bid,
													@PathVariable String bissuer)
	{
		Books b=service.getBookByIdAndIssuer(bid,bissuer);
		return new ResponseEntity<Books>(b,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Books b)
	{
		String s=service.updateData(b);
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bid}")
	public ResponseEntity<String> delete(@PathVariable int bid)
	{
			String s=service.delete(bid);
			
			return new ResponseEntity<String>("data deleted",HttpStatus.OK);
	}
	
	
	
}
