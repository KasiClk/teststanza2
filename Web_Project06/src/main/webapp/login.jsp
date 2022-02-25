<%@ include file="header.jsp"%>

<div class="container" style="width: 500px; margin-top: 250px;">
	<h1>Login</h1>
	<form action="gestione_login" method="POST">
		<div class="mb-3">
			<label for="email" class="form-label">Email address</label> 
			<input type="email" name="email" class="form-control" id="email">
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label>
			<input type="password" name="password" class="form-control" id="password">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="check" name="check">
			<label class="form-check-label" for="check">Check me out</label>
		</div>
		<div class="mb-3">
			<button type="submit" class="btn btn-primary form-control">Login</button>
		</div>
	</form>
</div>

<%@ include file="footer.jsp"%>