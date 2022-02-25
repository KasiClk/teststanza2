<%@page import="model.User"%>
<%@page import="controller.GestioneProdotto"%>
<%@page import="model.Prodotto"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp"%>

<%
	ArrayList<Prodotto> listaProdotti = GestioneProdotto.db.getAllProdotti();

	session = request.getSession();
	User utente = null;
	if(session.getAttribute("userLogin") == null) {
		response.sendRedirect("login.jsp");
	} else {
		utente = (User) session.getAttribute("userLogin");
	
%>


<div class="container my-3">
	<h1>Prodotti</h1>
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nome</th>
				<th scope="col">Categoria</th>
				<th scope="col">Prezzo</th>
				<th scope="col">Quantità</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
		<% for(Prodotto prodotto: listaProdotti) { %>
			<tr>
				<th scope="row"><%= listaProdotti.indexOf(prodotto)+1 %></th>
				<td><%= prodotto.getNome_prodotto() %></td>
				<td><%= prodotto.getCategoria().getNome_categoria() %></td>
				<td><%= prodotto.getPrezzo() %></td>
				<td><%= prodotto.getQt() %></td>
				<td>
					<a class="btn btn-danger btn-sm" href="gestione_prodotto?remove=<%= prodotto.getId_prodotto() %>" role="button"><i class="bi bi-trash3-fill"></i></a>
					<a class="btn btn-warning btn-sm" href="modifica_prodotto.jsp?edit=<%= prodotto.getId_prodotto() %>" role="button"><i class="bi bi-pencil-fill"></i></a>
					<a class="btn btn-warning btn-sm" href="gestione_prodotto?chart=<%= prodotto.getId_prodotto() %>" role="button"><i class="bi bi-cart4"></i></a>
				</td>
			</tr>
		<% } %>
		</tbody>
	</table>
</div>

<% } %>
<%@ include file="footer.jsp"%>