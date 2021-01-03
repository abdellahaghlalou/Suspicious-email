package SyStem;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/Register.jsp"; 
	public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "pass";
    public static final String CHAMP_CONF = "confirmation";
    public static final String CHAMP_NOM = "username";

    public Register() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		String motDePasse = request.getParameter( CHAMP_PASS );
        String confirmation = request.getParameter( CHAMP_CONF );
        String nom = request.getParameter( CHAMP_NOM );
        System.out.println(nom);
        System.out.println(motDePasse);
        String email= request.getParameter( CHAMP_EMAIL );
		Utilisateur Nv_utili = new Utilisateur(email,motDePasse,nom) ;
		RegisterUtilisateur enreg=new RegisterUtilisateur(Nv_utili);
		enreg.utili_bdd(Nv_utili);  
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp" ).forward( request, response );   
	    
		
	}

}
