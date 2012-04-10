
<%@ include file="header.jsp" %>


						<form class="well form-inline" method="POST" action="login">
							<label for="username">Usuario:</label>
							<input type="text" name="username" class="span3" value="<c:out value="${username}" />" />
							<label for="password">Contrase&ntilde;a</label>
							<input type="password" name="password" />
							<label class="checkbox">
								<input type="checkbox" name="rememberu"> Recordar usuario </input>
							</label>
							<label class="checkbox">
								<input type="checkbox" name="remember"> Recordar usuario y contrase&ntilde;a </input>
							</label>
							<input type="submit" name="submit" value="Ingresar" class="btn" />
							<span class="help-inline">${error}</span>
						</form>
						
						<a href="signUp">Registrarse</a>
						
<%@ include file="footer.jsp" %>