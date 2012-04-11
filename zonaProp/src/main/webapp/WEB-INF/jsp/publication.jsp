
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
						<b>Ubicaci&oacute;n:</b> ${publication.address}, ${publication.city}
						<br/>
						<b>Ambientes:</b> ${publication.environments}
						<br/>
						<b>Area:</b> ${publication.covered} metros cubiertos y ${publication.uncovered} metros descubiertos
						<br/>
						<b>Antig&uuml;edad:</b> ${publication.age} a&ntilde;os
						<br/>
						<b>Precio:</b> ${publication.price} pesos
						<br/>
						<b>Servicios:</b>
						<c:if test="${publication.cable}">cable</c:if>
						<c:if test="${publication.phone}"> telefono</c:if>
						<c:if test="${publication.pool}"> pileta</c:if>
						<c:if test="${publication.living}"> salon</c:if>
						<c:if test="${publication.paddle}"> cancha de paddle"</c:if>
						<c:if test="${publication.barbecue}"> parrilla</c:if>
						<br/>
						<b>Descripcion:</b> ${publication.description}
						<div>
							<b>Ubicacion en el mapa:</b>
							<br/>							
							<a target="_blank"	href="http://maps.google.com/maps?oe=UTF-8&gfns=1&q=${publication.city}+${publication.address}&um=1&ie=UTF-8&hq=&hnear=0x95bccabde7ad73db:0x4945c65ee2469ece,${publication.city}+${publication.address}&ei=7pGET-qfCYmhtweOv737Bw&sa=X&oi=geocode_result&ct=image&resnum=1&ved=0CCQQ8gEwAA">
              					 <img ALT="Mapa" class="mapa" src="http://maps.google.com/maps/api/staticmap?center=${publication.city}+${publication.address}&zoom=14&size=400x400&maptype=roadmap&markers=${publication.city}+${publication.address}&sensor=false"></img>
                           	</a>

						</div>
					</div>
					
				<c:if test="${not empty publication.photos}">
					<div class="well">
							<c:forEach items="${publication.photos}" var="photo">
									<img width="250" src="<c:url value="photoShower"><c:param name="imageId" value="${photo.id}" /></c:url>" /> </img>							
							</c:forEach> 
					</div>
				</c:if>
					
					<form class="well form-horizontal" method="POST" action="publication">
							<c:forEach items="${errors}" var="error">
								<p class="error">${error}</p>
							</c:forEach>
					
					
							<label for="name">Nombre:</label>
							<input type="text" name="name" class="span3" value="${vf.name}" />
							
							<label for="phone">Tel&eacute;fono:</label>
							<input type="text" name="phone" class="span3" value="${vf.phone}"/>
							
							<label for="email">E-mail:</label>
							<input type="text" name="email" class="span3" value="${vf.email}"/>
							
							<input type="hidden" name="publicationId" value="${publication.publicationId}"/>
							
							<label for="comment">Comentario:</label>
							<textarea name="comment" rows="10" cols="20">${vf.comment}</textarea>	
							<br/>
							<input type="submit" name="submit" value="Enviar" class="btn" />
					</form>
				</c:if>
					
						
<%@ include file="footer.jsp" %>