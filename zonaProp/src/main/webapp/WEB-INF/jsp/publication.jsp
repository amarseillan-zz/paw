
<%@ include file="header.jsp" %>

					<div>
						<h3>
							Publicacion:
						</h3>
						<b>ubicacion:</b> ${publication.address}, ${publication.city}
						<br/>
						<b>ambientes:</b> ${publication.environments}
						<br/>
						<b>area:</b> ${publication.covered} metros cubiertos y ${publication.uncovered} metros descubiertos
						<br/>
						<b>antiguedad:</b> ${publication.age} años
						<br/>
						<b>precio:</b> ${publication.price} pesos
						<br/>
					</div>
						
<%@ include file="footer.jsp" %>