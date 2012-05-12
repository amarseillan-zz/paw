
<%@ include file="../header.jsp" %>


<c:if test="${empty pList}">
	<h2>No se encontraron publicaciones</h2>
</c:if>

<c:if test="${not empty pList}">
	<h2>Publicaciones encontradas</h2>
	
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Tipo de Operaci&oacute;n</th>
			<th>Tipo de inmueble</th>
			<th>Direcci&oacute;n</th>
			<th>Barrio</th>
			<th>Precio</th>
			<th>Acciones</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${pList}" var="publication">
			<tr>
			<td>${publication.operationType.name}</td>
			<td>${publication.propertyType.name}</td>
			<td>${publication.address}</td>
			<td>${publication.city}</td>
			<td>${publication.price}</td>
			<td>
				<a href="<c:url value="view">
						<c:param name="publicationId" value="${publication.id}" />
					</c:url>">
					ver
				</a>
			</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>

<form class="form-horizontal" method="GET" action="search">
	<fieldset>
			<div class="form-actions">
					<button type="submit" class="btn btn-primary">Modificar la b&uacute;squeda</button>
			</div>
	</fieldset>
</form>

<%@ include file="../footer.jsp" %>