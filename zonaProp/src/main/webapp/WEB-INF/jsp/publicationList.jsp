
<%@ include file="header.jsp" %>

<h2>Sus publicaciones</h2>

<a href="publicationDetail">Nueva publicaci&oacute;n</a>
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
		<td>${publication.type}</td>
		<td>${publication.price}</td>
		<td>${publication.age}</td>
		<td>
			<a href="<c:url value="publicationView"><c:param name="id" value="${publication.publicationId}" /></c:url>">
				ver
			</a>
			<a href="<c:url value="publicationDetail">
					<c:param name="id" value="${publication.publicationId}" />
				</c:url>">
				editar
			</a>
		</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<%@ include file="footer.jsp" %>