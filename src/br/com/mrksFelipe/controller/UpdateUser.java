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

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	
	
    public UpdateUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		if(cmd.equalsIgnoreCase("update1"))
			update1(request, response);
		else if(cmd.equalsIgnoreCase("update2"))
			update2(request, response);
	}
	
	protected void update1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBusiness userBusiness = new UserBusiness(JPA.em());  
		
		
		try {
			Long idUser = Long.parseLong( request.getParameter("idUser") );
			
			User user =  userBusiness.findByID(idUser);
			
			request.setAttribute("id", user.getId());
			request.setAttribute("name", user.getName());
			request.setAttribute("login", user.getLogin());
			request.setAttribute("password", user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			request.getRequestDispatcher("update_user.jsp").forward(request, response);
		}
		
		
	}
	protected void update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBusiness userBusiness = new UserBusiness(JPA.em());  
		User user = new User();
		List<User> users = new ArrayList<User>();
		String msg = "";
		
		try {
			//Pegando os parametros da pagina
			user.setId( Long.parseLong(request.getParameter("id"))  );
			user.setLogin( request.getParameter("login") );
			user.setName( request.getParameter("name"));
			user.setPassword( request.getParameter("password") );
			
			//Editando o usuario
			userBusiness.update(user);
			msg = "Editado com Sucesso :" + user.getName();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Não foi possivel editar o usuário, <br />preencha os campos necessarios ou <br />o login já esta sendo utilizado";
		}finally{
		
			//Recarregando a lista para exibir na pagina
			
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
