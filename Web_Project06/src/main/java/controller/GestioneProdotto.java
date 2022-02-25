package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBConnect;

@WebServlet("/gestione_prodotto")
public class GestioneProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public static DBConnect db = new DBConnect();
       
    public GestioneProdotto() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("remove") != null) {
			db.eliminaProdotto(Integer.parseInt(request.getParameter("remove")));
		}
		response.sendRedirect("tab_prodotti.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome").trim();
		int id_categoria = Integer.parseInt(request.getParameter("categoria"));
		double prezzo = 0;
		int qt = 0;
		if(!request.getParameter("prezzo").trim().equals("")) {
			prezzo = Double.parseDouble(request.getParameter("prezzo").trim());
		}
		if(!request.getParameter("qt").trim().equals("")) {
			qt = Integer.parseInt(request.getParameter("qt").trim());
		}
		
		if(!nome.equals("") && id_categoria > 0 && prezzo > 0 && qt >= 0) {
			if(request.getParameter("edit") != null) {
				db.modificaProdotto(Integer.parseInt(request.getParameter("edit")), nome, id_categoria, prezzo, qt);
			} else {
				db.insertProdotto(nome, id_categoria, prezzo, qt);
			}
			
		}
		
		response.sendRedirect("tab_prodotti.jsp");
	}

}