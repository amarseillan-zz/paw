<%@ include file="../header.jsp" %>


<p class="error">${error}</p>

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
						<input type="hidden" name="publicationId" value="${publication.publicationId}" />			
						<button type="submit">Eliminar</button>
						</fieldset>
					</form>					
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>

	<form class="form-horizontal" method="POST" action="uploadPhoto" enctype="multipart/form-data">
			<div class="control-group">
				 <label class="control-label" for="photo">Agregar foto</label>
				 <div class="controls">
						<input type="hidden" name="publicationId" value="${publication.publicationId}" />		
				        <input name="photo" type="file"/>
				 <button type="submit" class="btn btn-primary">Subir</button>       
				 </div>
			</div>			
		</fieldset>	
	</form>
	<div class="form-actions">
				<a href="<c:url value="publicationDetail"><c:param name="pid" value="${publication.publicationId}" /></c:url>"  class="btn btn-primary"/>Volver</a>
	</div>
	
<%@ include file="../footer.jsp" %>	