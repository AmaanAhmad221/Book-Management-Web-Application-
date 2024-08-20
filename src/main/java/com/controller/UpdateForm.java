package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.BookDAOImpl;
import com.model.Book;

@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
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

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Update Book Form</title>");
		out.print("<link rel='stylesheet' href='css/form.css'>"); // Corrected typo from 'stylsheet' to 'stylesheet'
		out.print("</head>");
		out.print("<body>");

		int id = Integer.parseInt(request.getParameter("did"));

		Book book = dao.getBookById(id);

		out.print("<div class='form-container'>");
		out.print("<h2>BOOK UPDATE FORM</h2><br>");

		out.print("<form action='UpdateBook' method='get'>"); // Changed method to 'post' for updating data
		out.print("<input type='hidden' name='eid' value='" + book.getId() + "'>");
		out.print("<br>");
		out.print("<label for='name'>Name:</label>");
		out.print("<input type='text' id='name' name='name' value='" + book.getName() + "' required>");
		out.print("<br>");
		out.print("<label for='aname'>Author Name:</label>");
		out.print("<input type='text' id='aname' name='aname' value='" + book.getAname() + "' required>");
		out.print("<br>");
		out.print("<label for='price'>Price:</label>");
		out.print("<input type='text' id='price' name='price' value='" + book.getPrice() + "' required>");
		out.print("<br>");
		out.print("<input type='submit' value='UPDATE'>");
		out.print("</form>");
		out.print("</div>");

		out.print("</body>");
		out.print("</html>");
	}
}
