
<%@ include file="header.jsp" %>

<h2>Login</h2>
<div class="control-group.error">
	<c:out value="${error}" />
</div>
<form class="well form-inline" method="POST" action="login">
	<label for="username">Usuario:</label>
	<input type="text" name="username" class="span3"
		value="<c:out value="${username}" />" />
	<label for="password">Contrase&ntilde;a
	</label>
	<input type="password" name="password" />
	<label class="checkbox">
		<input type="checkbox"> Remember me </input>
	</label>
	<input type="submit" name="submit" value="Ingresar" class="btn" />
</form>

<%@ include file="footer.jsp" %>