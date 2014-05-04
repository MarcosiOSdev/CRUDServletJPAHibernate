package br.com.mrksFelipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrksFelipe.business.UserBusiness;
import br.com.mrksFelipe.filter.JPA;
import br.com.mrksFelipe.model.User;

@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CreateUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				UserBusiness userBusiness = new UserBusiness(JPA.em());
		
				User user = new User();
				String msg = "";
				
				try {
					user.setLogin(request.getParameter("login"));
					user.setName(request.getParameter("name"));
					user.setPassword(request.getParameter("password"));
					user.setId(null);
					userBusiness.save(user);
					msg="Cadastrado com sucesso!";
					
				} catch (Exception e) {
					e.printStackTrace();
					msg="Não foi possivel fazer o Cadastro, preencha os campos ou login ja deve estar sendo utilizado";
				}finally{
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("create_user.jsp").forward(request, response);
				}
	}
}
