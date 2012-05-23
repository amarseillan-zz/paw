<%@ include file="../header.jsp" %>

<c:if test="${empty list}">
	<h2>No se encontraron inmobiliarias</h2>
</c:if>

<c:if test="${not empty list}">
	<h2>Inmobiliarias registradas</h2>
	
	<c:forEach items="${list}" var="realEstate">
		<div class="well" >
			<table>	<tbody>
				<tr>
				<td><img class="image" src="<c:url value="../photo/view"><c:param name="imageId" value="${realEstate.photo.id}" /></c:url>" /></td>
				<td><h3>${realEstate.companyName}</h3>
				<br><h5>Cantidad de avisos: <c:out value="${realEstate.activePublicationsQuantity}"/> <h5>
				<br>
					<h5><a href="<c:url value="../publication/searchResults">
							<c:param name="publisher" value="${realEstate.id}" />
						</c:url>">
						ver publicaciones
					</a></h5>
				</td>
				</tr>
			</table> </tbody>
		</div>
	</c:forEach>
</c:if>
						
<%@ include file="../footer.jsp" %>