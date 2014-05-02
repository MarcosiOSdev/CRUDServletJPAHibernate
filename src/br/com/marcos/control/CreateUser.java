package br.com.marcos.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.marcos.entity.User;

@WebServlet("/createUser")
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
		
		try {
			
			
			String cmd = request.getParameter("cmd");
			if (cmd.equalsIgnoreCase("inserir")){
				request.getRequestDispatcher("create_user.jsp").forward(request, response);
			}else if(cmd.equalsIgnoreCase("create")){
				
				User user = new User();
				user.setLogin(request.getParameter("login"));
				user.setName(request.getParameter("name"));
				user.setPassword(request.getParameter("password"));
				
				user.setId(null);
				
				
				System.out.println(user);
				request.setAttribute("msg", "Cadastrado com sucesso!");
				request.getRequestDispatcher("create_user.jsp").forward(request, response);
				
			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
