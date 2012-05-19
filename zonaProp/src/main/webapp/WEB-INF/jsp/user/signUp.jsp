<%@ include file="../header.jsp" %>

<h2>Register</h2>

<form:form class="form" method="POST" action="signUp" enctype="multipart/form-data" commandName="userForm">
		<div class="error"><form:errors path="*" /></div>

	<c:if test="${userForm.userType.name == 'PRIVATEUSER'}">
		<div class="fieldset">
			<label for="name">(*)Nombre:</label>
			<form:input type="text" path="name" />
		</div>
		<div class="fieldset">
			<label for="lastname">(*)Apellido:</label>
			<form:input type="text" path="lastname" />
		</div>
	</c:if>
	
	<c:if test="${userForm.userType.name == 'REALESTATE'}">
		<div class="fieldset">
			<label for="name">(*)Nombre de la compania:</label>
			<form:input type="text" path="companyName" />
		</div>
		<div class="fieldset">
			<label for="name">(*)Logo:</label>
			<form:input type="file" path="fileData"/>
		</div>
	
	</c:if>
	
	<div class="fieldset">
		<label for="email">(*)E-mail:</label>
		<form:input type="text" path="email" />
	</div>
	<div class="fieldset">
		<label for="phone">(*)Nro tel:</label>
		<form:input type="text" path="phone" />
	</div>
	<div class="fieldset">
		<label for="username">(*)Usuario:</label>
		<form:input type="text" path="username" />
	</div>
	<div class="fieldset">
		<label for="password">(*)Contrase&ntilde;a:</label>
		<form:input type="password" path="password" />
	</div>
	<div class="fieldset">
		<label for="password2">(*)Ingrese contrase&ntilde;a nuevamente:</label>
		<form:input type="password" path="password2" />
	</div>
	<div class="form-buttons">
		<input type="submit" path="submit" value="Ingresar" />
	</div>
	<form:input type="hidden" path="userType"/>
</form:form>
<div class="footer">Los datos con asterisco (*) son abligatorios</div>
<%@ include file="../footer.jsp" %>