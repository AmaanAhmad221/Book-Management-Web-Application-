package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;

@WebServlet("/ReadBook")
public class ReadBook extends HttpServlet {
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

		out.println("<html><head>");
		out.println("<link rel='stylesheet' href='css/table.css'>");
		out.println("</head><body>");

		List<Book> list = dao.getAlLBooks();
		if (list == null || list.isEmpty()) {
			out.println("<h3>No Books found</h3>");
		} else {
			out.println("<table id='customers'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>Name</th>");
			out.println("<th>AuthorName</th>");
			out.println("<th>Price</th>");
			out.println("<th>DELETE</th>");
			out.println("<th>UPDATE</th>");
			out.println("</tr>");

			Iterator<Book> itr = list.iterator();
			while (itr.hasNext()) {
				Book book = itr.next();
				out.println("<tr>");
				out.println("<td>" + book.getId() + "</td>");
				out.println("<td>" + book.getName() + "</td>");
				out.println("<td>" + book.getName() + "</td>");
				out.println("<td>" + book.getPrice() + "</td>");
				out.println("<td><a href='DeleteBook?did=" + book.getId() + "'>DELETE</a></td>");
				out.println("<td><a href='UpdateForm?did=" + book.getId() + "'>UPDATE</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}

		out.println("</body></html>");
	}

}
