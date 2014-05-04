package br.com.mrksFelipe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.UserBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.User;

@WebServlet("/FindUser")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FindUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	/***
	 * 
	 * Execute --> aqui fica todas as consultas de Usuário. Exemple: busca usuario por nome , buscar usuario por login e etc.
	 * Execute ---> here stay find everything users . Exemple: find user by name, find user by login and etc.
	 * 
	 * **/
	
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("findAll"))
			findAll(request, response);
	}
	
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBusiness userBusiness = new UserBusiness(JPA.em());
		List<User> users = new ArrayList<User>();
		try {
			users = userBusiness.findAll();
			request.setAttribute("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			request.getRequestDispatcher("users.jsp").forward(request, response);
		}
	}
	
	
	

}
