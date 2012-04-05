<%@ include file="header.jsp" %>

<div class="control-group.error"><c:out value="${error}" /></div>

	<div class="well">
	<table style="width: 20%;">
		<c:forEach items="${photos}" var="photo">	
			<tr>
				<td>						
					<img style="width:100%" src="<c:url value="photoShower"><c:param name="imageId" value="${photo.id}" /></c:url>" /> </img>							
				</td>				
				<td>					
					<form  method="POST" action="photoDeleter?imageId=${photo.id}&pid=${pid}">				
						<button type="submit">Eliminar</button>
						</fieldset>
					</form>					
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>

	<form class="form-horizontal" method="POST" action="photoUpload" enctype="multipart/form-data">
			<div class="control-group">
				 <label class="control-label" for="photo">Agregar foto</label>
				 <div class="controls">
				        <input name="photo" type="file"/>
				 </div>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">Subir</button>
			</div>
		</fieldset>	
	</form>
	
<%@ include file="footer.jsp" %>	