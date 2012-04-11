<%@ include file="header.jsp" %>

<h2>Register</h2>
<c:forEach items="${errors}" var="error">
	<p class="error">${error}</p>
</c:forEach>
<form class="form" method="POST" action="signUp">
	<div class="fieldset">
		<label for="username">(*)Usuario:</label>
		<input type="text" name="username" value="<c:out value="${uf.username}" />" />
	</div>
	<div class="fieldset">
		<label for="name">(*)Nombre:</label>
		<input type="text" name="name" value="<c:out value="${uf.name}" />" />
	</div>
	<div class="fieldset">
		<label for="lastname">(*)Apellido:</label>
		<input type="text" name="lastname" value="<c:out value="${uf.lastname}" />" />
	</div>
	<div class="fieldset">
		<label for="mail">(*)E-mail:</label>
		<input type="text" name="mail" value="<c:out value="${uf.mail}" />" />
	</div>
	<div class="fieldset">
		<label for="phone">(*)Nro tel:</label>
		<input type="text" name="phone" value="<c:out value="${uf.phone}" />" />
	</div>
	<div class="fieldset">
		<label for="password">(*)Contrase&ntilde;a:</label>
		<input type="password" name="password1" value="<c:out value="${uf.password1}"/>"/>
	</div>
	<div class="fieldset">
		<label for="password">(*)Ingrese contrase&ntilde;a nuevamente:</label>
		<input type="password" name="password2" value="<c:out value="${uf.password2}"/>"/>
	</div>
	<div class="form-buttons">
		<input type="submit" name="submit" value="Ingresar" />
	</div>
</form>
<div class="footer">Los datos con asterisco (*) son abligatorios</div>
<%@ include file="footer.jsp" %>