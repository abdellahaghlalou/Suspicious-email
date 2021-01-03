package SyStem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*;
import java.io.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_LOGIN = "/WEB-INF/Login.jsp"; 
	public static final String VUE_INBOX = "/WEB-INF/Inbox.jsp";
	public static final String VUE_Admin = "/WEB-INF/AdminPanel.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( VUE_LOGIN ).forward( request, response );
		
		response.setContentType("text/html;charset=UTF-8");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        System.out.println(email + pass);
        if(email.equals("admin@sys.org") && pass.equals("admin") ) {
        	System.out.println(email + pass);
        	this.getServletContext().getRequestDispatcher( VUE_Admin ).forward( request, response );
        	
        }
        else if(ValidateLogin.checkUser(email, pass)) {
        
            RequestDispatcher rs = request.getRequestDispatcher(VUE_INBOX);
            rs.forward(request, response);
        }
        else
        {
        	response.setContentType("text/html;charset=UTF-8");
        	PrintWriter out = response.getWriter();
           out.println("Username or Password incorrect");
           out.println("repeat<a href='/Application/Login.jsp'>login</a> or <a href='/Application/Register.jsp'>Register</a> ");
        }
        
	}

}
