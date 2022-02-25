<%@page import="model.User"%>
<%@ include file="header.jsp" %>

<% session = request.getSession();
	User utente = null;
	if(session.getAttribute("userLogin") == null) {
		response.sendRedirect("login.jsp");
	} else {
		utente = (User) session.getAttribute("userLogin");
	
%>

<div class="container my-3">
	<h1>Nuova Categoria</h1>
	<form action="gestione_categorie" method="POST">
		<div class="mb-3">
			<label for="categoria" class="form-label">Nome Categoria</label> 
			<input type="text" name="categoria" class="form-control" id="categoria" required="required" >
		</div>
		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Inserisci Categoria</button>
		</div>
		
	</form>
</div>

<% } %>
<%@ include file="footer.jsp" %>