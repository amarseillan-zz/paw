<%@ include file="header.jsp" %>
<div class="control-group.error"><c:out value="${error}" /></div>
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