<%@ include file="../header.jsp" %>

<c:if test="${empty list}">
	<h2>No se encontraron inmobiliarias</h2>
</c:if>

<c:if test="${not empty list}">
	<h2>Inmobiliarias registradas</h2>
	
	<c:forEach items="${list}" var="realEstate">
		<div class="well">
			<table>	<tbody>
				<tr>
				<td><img width="200" src="<c:url value="../publication/viewPhoto"><c:param name="imageId" value="${realEstate.photo.id}" /></c:url>" /> </img></td>
				<td><h3>${realEstate.companyName}</h3>
				<br>Cantidad de avisos: <c:out value="${realEstate.activePublicationsQuantity}"/> 
				<br>
					<a href="<c:url value="../publication/searchResults">
							<c:param name="publisher" value="${realEstate.id}" />
						</c:url>">
						ver
					</a>
				</td>
				</tr>
			</table> </tbody>
		</div>
	</c:forEach>
</c:if>
						
<%@ include file="../footer.jsp" %>