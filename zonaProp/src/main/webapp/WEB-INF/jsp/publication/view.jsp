
<%@ include file="../header.jsp" %>
				<c:if test="${empty publication}">
					<h3>
						La publicacion es inexistente o fue dada de baja.
					</h3>
				</c:if>
				<c:if test="${not empty publication}">
					<c:if test="${showPublisher}">
						<%@ include file="../userInfo.jsp" %>
					</c:if>
					
					<a href="<c:url value="../publication/searchResults">
						<c:param name="publisher" value="${publication.publisher.id}" />
					</c:url>">Otras publicaciones del usuario
					</a>
					
					<div class="well">
						<h3>
							Publicacion: ${publication.operationType.name} de ${publication.propertyType.name}</h3>
							<h6><c:if test="${publication.access != 0}">
								(Visto 	${publication.access}	
								<c:if test="${publication.access == 1}">vez</c:if>
								<c:if test="${publication.access != 1}">veces</c:if>
								 )</c:if></h6>
						<b>Ubicaci&oacute;n:</b> ${publication.address}, ${publication.city}
						<br/>
						<b>Ambientes:</b> ${publication.environments}
						<br/>
						<b>Area:</b> ${publication.covered} metros cubiertos y ${publication.uncovered} metros descubiertos
						<br/>
						<c:forEach var="env" items="${publication.environmentList}">
							${env.type.name} de ${env.width}x${env.depth}.<br/>
						</c:forEach>
						<b>Antig&uuml;edad:</b> ${publication.age} a&ntilde;os
						<br/>
						<b>Precio:</b> ${publication.price} pesos
						<br/>
						<c:if test="${not empty publication.propertyServices}">
						<b>Servicios:</b>
						<c:forEach var="service" items="${publication.propertyServices}">
							${service.name}.
						</c:forEach>
						<br/>
						</c:if>
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
									<img class="image" src="<c:url value="../photo/view"><c:param name="imageId" value="${photo.id}" /></c:url>" /> 
									<c:if test="${publication.reserved}">
										<img class="pic-on-pic" src="../../imgs/reserved.png"/>
									</c:if>			
							</c:forEach> 
					</div>
				</c:if>
					
					<form:form class="well form-horizontal" method="POST" action="comment" commandName="commentForm">
						
						<div class="error"><form:errors path="*" /></div>
						
						<input type="hidden" name="publicationId" value="${publication.id}"/>
							<label for="name">Nombre:</label>
							<form:input type="text" name="name" class="span3" path="name" />
							
							<label for="phone">Tel&eacute;fono:</label>
							<form:input type="text" name="phone" class="span3" path="phone"/>
							
							<label for="email">E-mail:</label>
							<form:input type="text" name="email" class="span3" path="email"/>
							
							
							<label for="comment">Comentario:</label>
							<form:textarea name="comment" rows="10" cols="20" path="comment"></form:textarea>	
							<br/>
							<input type="submit" name="submit" value="Enviar" class="btn" />
					</form:form>
					
				</c:if>
					
						
<%@ include file="../footer.jsp" %>