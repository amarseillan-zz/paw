<%@ include file="header.jsp" %>

<h2>Register</h2>
<div class="control-group.error"><c:out value="${error}" /></div>
<form class="form" method="POST" action="signUp">
	<div class="fieldset">
		<label for="username">(*)Usuario:</label>
		<input type="text" name="username" value="<c:out value="${user.username}" />" />
	</div>
	<div class="fieldset">
		<label for="name">(*)Nombre:</label>
		<input type="text" name="name" value="<c:out value="${user.name}" />" />
	</div>
	<div class="fieldset">
		<label for="lastname">(*)Apellido:</label>
		<input type="text" name="lastname" value="<c:out value="${user.lastName}" />" />
	</div>
	<div class="fieldset">
		<label for="mail">(*)E-mail:</label>
		<input type="text" name="mail" value="<c:out value="${user.email}" />" />
	</div>
	<div class="fieldset">
		<label for="phone">(*)Nro tel:</label>
		<input type="text" name="phone" value="<c:out value="${user.phone}" />" />
	</div>
	<div class="fieldset">
		<label for="password">(*)Contrase&ntilde;a:</label>
		<input type="password1" name="password1"/>
	</div>
	<div class="fieldset">
		<label for="password">(*)Ingrese contrase&ntilde;a nuevamente:</label>
		<input type="password2" name="password2"/>
	</div>
	<div class="form-buttons">
		<input type="submit" name="submit" value="Ingresar" />
	</div>
</form>
<div class="footer">Los datos con asterisco (*) son abligatorios</div>
<%@ include file="footer.jsp" %>