
<%@ include file="header.jsp" %>


						<form class="well form-inline" method="POST" action="login">
							<label for="username">Usuario:</label>
							<input type="text" name="username" class="span3" value="<c:out value="${username}" />" />
							<label for="password">Contrase&ntilde;a</label>
							<input type="password" name="password" />
							<label class="checkbox">
								<input type="checkbox" name="remember"> Remember me </input>
							</label>
							<input type="submit" name="submit" value="Ingresar" class="btn" />
							<span class="help-inline">${error}</span>
						</form>
						
<%@ include file="footer.jsp" %>