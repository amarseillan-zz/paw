
<%@ include file="../header.jsp" %>

<h2>Sus publicaciones</h2>

<a href="../publication/create">Nueva publicaci&oacute;n</a>
<table class="table table-striped">
	<thead>
	<tr>
		<th>Direcci&oacute;n</th>
		<th>Tipo</th>
		<th>Precio</th>
		<th>Antig&uuml;edad</th>
		<th>Acciones</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${pList}" var="publication">
		<tr>
		<td>${publication.address}</td>
		<td>${publication.propertyType.name}</td>
		<td>${publication.price}</td>
		<td>${publication.age}</td>
		<td>
			<a href="<c:url value="../publication/modify">
						<c:param name="publicationId" value="${publication.id}" />
					</c:url>">
				editar
			</a>
			<a href="<c:url value="../publication/view">
						<c:param name="publicationId" value="${publication.id}" />
					</c:url>">
				ver
			</a>
			<br/>
			<a href="<c:url value="../publication/editPhotos">
				<c:param name="publicationId" value="${publication.id}" />
			</c:url>
				">Editar Imagenes
			</a>
		</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@ include file="../footer.jsp" %>