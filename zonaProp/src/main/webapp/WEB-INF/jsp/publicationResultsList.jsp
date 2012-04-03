
<%@ include file="header.jsp" %>

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
		<td>${publication.operation_type}</td>
		<td>${publication.type}</td>
		<td>${publication.address}</td>
		<td>${publication.city}</td>
		<td>${publication.price}</td>
		<td>
			<a href="<c:url value="publication">
					<c:param name="publicationId" value="${publication.publicationId}" />
					<c:param name="userId" value="${publication.userId}" />
				</c:url>">
				ver
			</a>
		</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<form class="form-horizontal" method="GET" action="publicationSearch">
	<fieldset>
			<div class="form-actions">
					<button type="submit" class="btn btn-primary">Modificar la b&uacute;squeda</button>
			</div>
	</fieldset>
</form>

<%@ include file="footer.jsp" %>