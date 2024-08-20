package com.model;

public class Book {
	private int id;
	private String name;
	private String aname;
	private double price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, String aname, double price) {
		super();
		this.id = id;
		this.name = name;
		this.aname = aname;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", aname=" + aname + ", price=" + price + "]";
	}

}
