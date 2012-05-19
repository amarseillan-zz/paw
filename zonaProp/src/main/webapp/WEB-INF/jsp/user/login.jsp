
<%@ include file="../header.jsp" %>

					
						<form:form class="well form-inline" method="POST" action="login" commandName="loginUserForm">
							<div class="error"><form:errors path="*" /></div>
							<label for="username">Usuario:</label>
							<form:input type="text" path="username" class="span3" />
							<label for="password">Contrase&ntilde;a</label>
							<form:input type="password" path="password" />
							<label class="checkbox">
								Recordar usuario 
								<form:input type="checkbox" path="rememberu" value="on"></form:input>
							</label>
							<label class="checkbox">
								Recordar usuario y contrase&ntilde;a
								<form:input type="checkbox" path="remember" value="on"></form:input>
							</label>
							<input type="submit" name="submit" value="Ingresar" class="btn" />
							<span class="help-inline">${error}</span>
						</form:form>
						
						<a href="selectRegType">Registrarse</a>
						
<%@ include file="../footer.jsp" %>