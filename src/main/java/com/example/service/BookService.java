package com.example.service;

import java.util.List;

import com.example.Model.Books;

public interface BookService 
{

	String saveData(Books book);

	List<Books> getAllBooks();

	Books getBookByid(int bid);
	
	Books getbyName(String bname);

	Books getBookByIdAndIssuer(int bid, String bissuer);

	String updateData(Books b);

	String delete(int bid);

}
