package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.utility.DBUtility;

public class BookDAOImpl implements BookDAO {

	@Override
	public int saveBook(Book book) {
		Connection con = DBUtility.getDBConnection();
		String sql = "insert into books values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, book.getId());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAname());
			ps.setDouble(4, book.getPrice());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("BookDAO save" + e);

		}
		return 0;
	}

	@Override
	public int deleteBook(int id) {
		Connection con = DBUtility.getDBConnection();
		String sql = "delete from books where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Deleting Book " + e);
		}
		return 0;
	}

	@Override
	public int updateBook(Book book) {
		Connection con = DBUtility.getDBConnection();
		String sql = "update books set name=?,aname=?,price=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, book.getName());
			ps.setString(2, book.getAname());
			ps.setDouble(3, book.getPrice());
			ps.setInt(4, book.getId());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Updating Student" + e);
		}
		return 0;
	}

	@Override
	public List<Book> getAlLBooks() {
		List<Book> list = new ArrayList<Book>();
		Connection con = DBUtility.getDBConnection();
		String sql = "Select * from Books";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAname(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				list.add(book);
			}
		} catch (Exception e) {
			System.out.print("All Record " + e);
		}
		return list;
	}

	@Override
	public Book getBookById(int id) {
		Connection con = DBUtility.getDBConnection();
		String sql = "Select * from books where id=?";
		Book book = new Book();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setAname(rs.getString(3));
				book.setPrice(rs.getDouble(4));
			}
		} catch (Exception e) {
			System.out.println("Get Book By Id " + e);
		}
		return book;
	}

}
