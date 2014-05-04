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

@WebServlet("/RemoveUser")
public class RemoveUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public RemoveUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		delete(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		delete(request,response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBusiness userBusiness = new UserBusiness(JPA.em());
		User user = new User();
		List<User> users = new ArrayList<User>();
		String msg="";
		
		try {
			
			user.setId( Long.parseLong( request.getParameter("idUser") ));
			userBusiness.delete(user.getId(), User.class);
			
			msg="Removido Com Sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			msg="Erro ao deletar usuario";
		}finally{
			
			try {
				users = userBusiness.findAll();
				request.setAttribute("msg", msg);
				request.setAttribute("users", users);
				request.getRequestDispatcher("users.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
		
	}

}
