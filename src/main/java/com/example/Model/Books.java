package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books
{
	@Id
	private int bid;
	private String bname;
	private double price;
	private String bissuer;
	


}
