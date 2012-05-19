
<%@ include file="../header.jsp" %>


<form:form class="form-horizontal" method="POST" action="addEnvironment" commandName="environmentForm">

	<div class="error"><form:errors path="*" /></div>

	<fieldset>
	
		<div class="control-group">
			<label class="control-label" for="type">Tipo de ambiente</label>
			<div class="controls">
				<form:select path="env">
					<form:option value="" label="Tipo de ambiente"/>
					<form:options/>
		         </form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="width">Ancho</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge"
					path="width"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="depth">Largo</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge"
					path="depth"/>
			</div>
		</div>
		<input type="hidden" name="publicationId" value="${publication.id}" />	
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>

	</fieldset>
</form:form>
<%@ include file="../footer.jsp" %>