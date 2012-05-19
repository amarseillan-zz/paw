<%@ include file="../header.jsp" %>



	<div class="well">
	<table style="width: 20%;">
		<c:forEach items="${publication.photos}" var="photo">	
			<tr>
				<td>						
					<img width="200" src="<c:url value="viewPhoto"><c:param name="imageId" value="${photo.id}" /></c:url>" /> </img>							
				</td>				
				<td>					
					<form  method="POST" action="deletePhoto">
						<input type="hidden" name="imageId" value="${photo.id}" />	
						<input type="hidden" name="publicationId" value="${publication.id}" />			
						<button type="submit">Eliminar</button>
						</fieldset>
					</form>					
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<form:form class="well form-horizontal" method="POST" action="uploadPhoto" enctype="multipart/form-data" commandName="photoForm">
				<div class="error"><form:errors path="*" /></div>	
						
				<input type="hidden" name="publicationId" value="${publication.id}" path="publication"/>
				
				<form:input name="photo" type="file" path="fileData"/>
				
				<input type="submit" name="submit" value="Enviar" class="btn" />
	</form:form>
	
	<div class="form-actions">
				<a href="<c:url value="../user/publications"></c:url>"  class="btn btn-primary"/>Volver</a>
	</div>
	
<%@ include file="../footer.jsp" %>	