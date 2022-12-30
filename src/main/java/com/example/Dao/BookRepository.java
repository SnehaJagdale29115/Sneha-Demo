package com.example.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.Books;
public interface BookRepository extends JpaRepository<Books, Integer>
{

	Books findByBname(String bname);

	

	//Books findAllByBidAndBissuer(int bid, String bissuer);



	Books findByBidAndBissuer(int bid, String bissuer);

}
