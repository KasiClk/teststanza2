package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.DBConnect;

@WebServlet("/gestione_categorie")
public class GestioneCategorie extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static DBConnect db = new DBConnect();
       
    public GestioneCategorie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria = request.getParameter("categoria").trim();

		for (Categoria cat : db.getAllCategorie()) {
			if(cat.getNome_categoria().equals(categoria)) {
				categoria = "";
			}
		}
		
		if(!categoria.equals("")) {
			db.insertCategoria(categoria);
		}
		
		response.sendRedirect("nuova_categoria.jsp");
	}

}