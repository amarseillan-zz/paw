
<%@ include file="../header.jsp" %>


<form:form class="form-horizontal" method="POST" action="saveChanges" commandName="publicationForm">

	<div class="error"><form:errors path="*" /></div>

	<fieldset>
	
		<div class="control-group">
			<label class="control-label" for="type">Tipo de propiedad</label>
			<div class="controls">
				<form:select path="propertyType">
					<form:option value="" label="Tipo de propiedad"/>
					<form:options/>
		         </form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="operation_type">Tipo
				de operaci&oacute;n
			</label>
			<div class="controls">
				<form:select path="operationType">
					<form:option value="">Tipo de operaci&oacute;n</form:option>
					<form:options/>
		         </form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="address">Direcci&oacute;n
			</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge" maxlength="30"
					path="address"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="city">Ciudad</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge" maxlength="30"
					path="city"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="price">Precio</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge"
					path="price"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="environments">N&uacute;mero
				de ambientes
			</label>
			<div class="controls">
				<form:select path="environments">
					<form:option value="1" >1</form:option>
					<form:option value="2" >2</form:option>
					<form:option value="3" >3</form:option>
					<form:option value="4" >4</form:option>
					<form:option value="5" >5</form:option>
					<form:option value="6" >6</form:option>
					<form:option value="7" >7</form:option>
				</form:select>
			</div>
		</div>
		
		<c:forEach var="env" items="${publicationForm.environmentList}">
			<div class="control-group">
				<div class="controls">
					${env.type.name} de ${env.width}x${env.depth}.
						<a href="deleteEnv?publicationId=${publicationForm.publicationId}&envId=${env.id}">Eliminar</a>
				</div>
			</div>
		</c:forEach>
		
		<c:if test="${publicationForm.publicationId != 0}">
			<div class="control-group">
				<div class="controls">
					<a href="addEnvironment?publicationId=<c:out value="${publicationForm.publicationId}"/>">Agregar ambiente</a>
				</div>
			</div>
		</c:if>
		
		<div class="control-group">
			<label class="control-label" for="covered">Superficie cubierta</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge"
					path="covered"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="uncovered">Superficie descubierta</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge"
					path="uncovered"/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="age">Antig&uuml;edad
			</label>
			<div class="controls">
				<form:input type="text" class="input-xlarge"
					path="age"/>
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
				<form:checkboxes class="input-checkbox" path="propertyServices" items="${services}"/>
			</div>	
		</div>
		
		<div class="control-group">
			<label class="control-label" for="description">Descripci&oacute;n
			</label>
			<div class="controls">
				<form:textarea class="input-xlarge" rows="3" path="description"
					style="margin-top: 0px; margin-bottom: 0px; height: 54px; margin-left: 0px; margin-right: 0px; width: 533px; "/>
			</div>
		</div>

		<form:input type="hidden" path="publicationId" />

		<div class="control-group">
			<label class="control-label" for="active">Estado</label>
			<div class="controls">
				<form:select path="active">
					<form:option label="Activa" value="true"/>
					<form:option label="Inactiva" value="false"/>
				</form:select>
			</div>
			
			<div class="controls">
				<form:select path="reserved">
					<form:option label="No reservado" value="false"/>
					<form:option label="Reservado" value="true"/>
				</form:select>
			</div>
		</div>
		
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>

	</fieldset>
</form:form>
<%@ include file="../footer.jsp" %>