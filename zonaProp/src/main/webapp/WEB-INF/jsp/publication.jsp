
<%@ include file="header.jsp" %>

					<div>
						<h3>
							Publicacion:
						</h3>
						<b>Ubicacion:</b> ${publication.address}, ${publication.city}
						<br/>
						<b>Ambientes:</b> ${publication.environments}
						<br/>
						<b>Area:</b> ${publication.covered} metros cubiertos y ${publication.uncovered} metros descubiertos
						<br/>
						<b>Antiguedad:</b> ${publication.age} años
						<br/>
						<b>Precio:</b> ${publication.price} pesos
						<br/>
					</div>
					
					<form class="well form-horizontal" method="POST" action="publication">
					
							<label for="name">Nombre:</label>
							<input type="text" name="name" class="span3" />
							
							<label for="phone">Telefono:</label>
							<input type="text" name="phone" class="span3" />
							
							<label for="email">E-mail:</label>
							<input type="text" name="email" class="span3" />
							
							<label for="comment">Comentario:</label>
							<textarea name="comment" rows="10" cols="20"></textarea>
							<br/>
							<input type="submit" name="submit" value="Enviar" class="btn" />
							<span class="help-inline">${error}</span>
					</form>
					
					
						
<%@ include file="footer.jsp" %>