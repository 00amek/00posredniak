package com.user.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.models.User;
import com.user.models.User_entity;
import com.user.service.UserService;

/**
 * Servlet implementation class AddUser_entity
 */
@WebServlet("/AddUser_entity")
public class AddUser_entity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@EJB
	UserService us;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("Login_name", "");
		request.setAttribute("Imie_name", "");
		request.setAttribute("Nazwisko_name", "");
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/Add_User.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("error", false);
		User_entity a = new User_entity();

		String login = request.getParameter("Login");
		if (login.length() == 0) {
			request.setAttribute("error", true);
			request.setAttribute("login", true);
			request.setAttribute("Login_name", "");
		} else {
			a.setLogin(login);
			request.setAttribute("Login_name", login);
		}
		String firstName = request.getParameter("Imie");
		if (firstName.length() == 0) {
			request.setAttribute("error", true);
			request.setAttribute("imie", true);
			request.setAttribute("Imie_name", "");
		} else {
			a.setFirstName(firstName);
			request.setAttribute("Imie_name", firstName);
		}
		String lastName = request.getParameter("Nazwisko");
		if (lastName.length() == 0) {
			request.setAttribute("error", true);
			request.setAttribute("nazwisko", true);
			request.setAttribute("Nazwisko_name", "");
		} else {
			a.setLastName(lastName);
			request.setAttribute("Nazwisko_name", lastName);
		}

		if ((Boolean) request.getAttribute("error")) {
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/Add_User.jsp");
			view.forward(request, response);
		} else {
			
			us.AddUser(a);
			response.sendRedirect("");
		}

	}

}
