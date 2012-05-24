
<%@ include file="../header.jsp" %>


<c:if test="${resultPage.pages == 0}">
	<h2>No se encontraron publicaciones</h2>
</c:if>

<c:if test="${resultPage.pages != 0}">
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
		<c:forEach items="${resultPage.publications}" var="publication">
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
	<c:forEach var="page" begin="0" end="${resultPage.pages -1}" step="1">
		<c:if test="${not empty searchForm.publisher}">
			<a href="searchResults?propertyType=${searchForm.propertyType}&operationType=${searchForm.operationType}&min=${searchForm.min}&max=${searchForm.max}&ascending=${searchForm.ascending}&_ascending=on&pageSize=${searchForm.pageSize}&page=${page}&publisher=${searchForm.publisher.id}"><c:if test="${page == searchForm.page}"><b></c:if>${page+1}<c:if test="${searchForm.page == page}"></b></c:if></a>
		</c:if>
		<c:if test="${empty searchForm.publisher}">
			<a href="searchResults?propertyType=${searchForm.propertyType}&operationType=${searchForm.operationType}&min=${searchForm.min}&max=${searchForm.max}&ascending=${searchForm.ascending}&_ascending=on&pageSize=${searchForm.pageSize}&page=${page}"><c:if test="${searchForm.page == page}"><b></c:if>${page+1}<c:if test="${searchForm.page == page}"></b></c:if></a>
		</c:if>
	</c:forEach>
</c:if>

<form class="form-horizontal" method="GET" action="search">
	<fieldset>
			<div class="form-actions">
					<button type="submit" class="btn btn-primary">Modificar la b&uacute;squeda</button>
			</div>
	</fieldset>
</form>

<%@ include file="../footer.jsp" %>