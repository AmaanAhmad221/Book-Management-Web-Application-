package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;
import com.utility.DBUtility;

@WebServlet("/InsertBook")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new BookDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String aname = request.getParameter("aname");
		String price = request.getParameter("price");

		int id1 = Integer.parseInt(id);
		double price1 = Double.parseDouble(price);
		Book book = new Book(id1, name, aname, price1);

		try {
			Connection con = DBUtility.getDBConnection();
			int i = dao.saveBook(book);
			if (i > 0) {
				out.print("<b>RECORD INSERTED SUCCESSFULLY!!!");
				RequestDispatcher rd = request.getRequestDispatcher("/ReadBook");
				rd.include(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
