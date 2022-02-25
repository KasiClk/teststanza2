package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

@WebServlet("/gestione_login")
public class GestioneLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private User utente;
       
    public GestioneLogin() {
        super();
    }

	@Override
	public void init() throws ServletException {
		super.init();
		this.utente = new User();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.trim().equals(this.utente.getEmail()) && password.trim().equals(this.utente.getPassword())) {
			
			HttpSession session =  request.getSession();
			session.setAttribute("userLogin", this.utente);
		}
		
		response.sendRedirect("tab_prodotti.jsp");
		
	}

}