<%@page import="model.User"%>
<%@page import="controller.*"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.GestioneProdotto"%>
<%@page import="model.Prodotto"%>
<%@ include file="header.jsp" %>

<%
	ArrayList<Categoria> listaCategorie = GestioneCategorie.db.getAllCategorie();
	int id = Integer.parseInt(request.getParameter("edit"));
	Prodotto p = GestioneProdotto.db.getProdotto(id);

	session = request.getSession();
	User utente = null;
	if(session.getAttribute("userLogin") == null) {
		response.sendRedirect("login.jsp");
	} else {
		utente = (User) session.getAttribute("userLogin");
	
%>

<div class="container my-3">
	<h1>Modifica Prodotto</h1>
	<% if(p != null) { %>
	<form action="gestione_prodotto?edit=<%= id %>" method="POST">
		<div class="mb-3">
			<label for="nome" class="form-label">Nome Prodotto</label> 
			<input type="text" name="nome" class="form-control" id="nome" value="<%= p.getNome_prodotto() %>" >
		</div>
		<div class="mb-3">
			<label for="categoria" class="form-label">Categoria</label> 
			<select class="form-select" name="categoria" id="categoria" required="required">
			<option selected value="0">---</option>
			<% for(Categoria categoria : listaCategorie) { 
				if(categoria.getId_categoria() == p.getCategoria().getId_categoria()) {
			%>	  
			  	<option value="<%= categoria.getId_categoria() %>" selected="selected"><%= categoria.getNome_categoria() %></option>
			<% } else { %>
				<option value="<%= categoria.getId_categoria() %>" ><%= categoria.getNome_categoria() %></option>
			<% }} %>
			</select>
		</div>
		<div class="mb-3">
			<label for="prezzo" class="form-label">Prezzo</label> 
			<input type="text" name="prezzo" class="form-control" id="prezzo" value="<%= p.getPrezzo() %>" >
		</div>
		<div class="mb-3">
			<label for="qt" class="form-label">Quantità</label> 
			<input type="number" name="qt" class="form-control" id="qt" value="<%= p.getQt() %>" >
		</div>
		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Modifica Prodotto</button>
		</div>
		
	</form>
	<% } else { %>
	<h1>Nessun Prodotto da modificare!!!!</h1>
	<% } %>
</div>

<% } %>
<%@ include file="footer.jsp" %>