<%@ include file="header.jsp" %>
<div class="control-group.error"><c:out value="${error}" /></div>

	<table style="width: 20%;">
		<c:forEach items="${photos}" var="photo">	
			<tr>
				<td>						
					<img style="width:100%" src="<c:url value="photoShower"><c:param name="imageId" value="${photo.id}" /></c:url>" /> </img>							
				</td>
				<td>
					<a href="<c:url value="photoDeleter"><c:param name="imageId" value="${photo.id}"/><c:param name="pid" value="${pid}"/></c:url>">Eliminar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
		

	<form class="form-horizontal" method="POST" action="photoUpload" enctype="multipart/form-data">
			<div class="control-group">
				 <label class="control-label" for="photo">Agregar foto</label>
				 <div class="controls">
				        <input name="photo" type="file"/>
				 </div>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">Subir</button>
				<button class="btn">Cancelar</button>
			</div>
		</fieldset>
	</form>
	
<%@ include file="footer.jsp" %>	