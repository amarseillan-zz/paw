
<%@ include file="header.jsp" %>
				<c:if test="${empty publication}">
					<h3>
						La publicacion es inexistente o fue dada de baja.
					</h3>
				</c:if>
				<c:if test="${not empty publication}">
					<c:if test="${showPublisher}">
						<%@ include file="userInfo.jsp" %>
					</c:if>
					
					<div class="well">
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
							<input type="text" name="name" class="span3" value="${vf.name}" />
							
							<label for="phone">Telefono:</label>
							<input type="text" name="phone" class="span3" value="${vf.phone}"/>
							
							<label for="email">E-mail:</label>
							<input type="text" name="email" class="span3" value="${vf.email}"/>
							
							<input type="hidden" name="publicationId" value="${publication.publicationId}"/>
							
							<label for="comment">Comentario:</label>
							<textarea name="comment" rows="10" cols="20">${vf.comment}</textarea>	
							<br/>
							<input type="submit" name="submit" value="Enviar" class="btn" />
							<span class="help-inline">${error}</span>
					</form>
				</c:if>
					
						
<%@ include file="footer.jsp" %>