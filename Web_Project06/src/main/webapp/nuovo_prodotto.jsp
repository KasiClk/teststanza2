<%@page import="model.User"%>
<%@page import="controller.*"%>
<%@page import="model.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>

<%
	ArrayList<Categoria> listaCategorie = GestioneCategorie.db.getAllCategorie();

	session = request.getSession();
	User utente = null;
	if(session.getAttribute("userLogin") == null) {
		response.sendRedirect("login.jsp");
	} else {
		utente = (User) session.getAttribute("userLogin");
	
%>

<div class="container my-3">
	<h1>Nuovo Prodotto</h1>
	<form action="gestione_prodotto" method="POST">
		<div class="mb-3">
			<label for="nome" class="form-label">Nome Prodotto</label> 
			<input type="text" name="nome" class="form-control" id="nome" required="required">
		</div>
		<div class="mb-3">
			<label for="categoria" class="form-label">Categoria</label> 
			<select class="form-select" name="categoria" id="categoria" required="required">
			<option selected value="0">---</option>
			<% for(Categoria categoria : listaCategorie) { %>	  
			  <option value="<%= categoria.getId_categoria() %>"><%= categoria.getNome_categoria() %></option>
			<% } %>
			</select>
		</div>
		<div class="mb-3">
			<label for="prezzo" class="form-label">Prezzo</label> 
			<input type="text" name="prezzo" class="form-control" id="prezzo" required="required">
		</div>
		<div class="mb-3">
			<label for="qt" class="form-label">Quantità</label> 
			<input type="number" name="qt" class="form-control" id="qt" required="required">
		</div>
		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Inserisci Prodotto</button>
		</div>
		
	</form>
</div>

<% } %>
<%@ include file="footer.jsp"%>