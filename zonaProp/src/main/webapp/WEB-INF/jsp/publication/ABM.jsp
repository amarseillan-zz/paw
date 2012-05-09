
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
					<form:option value="" label="Tipo de operaci&oacute;n"/>
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
			<label class="control-label" for="cable">Cable</label>
			<div class="controls">
				<label class="checkbox">
					<form:input type="checkbox" value="true" path="cable"/>
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="phone">Tel&eacute;fono
			</label>
			<div class="controls">
				<label class="checkbox">
					<form:input type="checkbox" value="true" path="phone"/>
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="pool">Pileta</label>
			<div class="controls">
				<label class="checkbox">
					<form:input type="checkbox" value="true" path="pool"/>
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="living">Sal&oacute;n
			</label>
			<div class="controls">
				<label class="checkbox">
					<form:input type="checkbox" value="true" path="living"/>
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="paddle">Cancha de paddle</label>
			<div class="controls">
				<label class="checkbox">
					<form:input type="checkbox" value="true" path="paddle"/>
				</label>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="barbecue">Quincho</label>
			<div class="controls">
				<label class="checkbox">
					<form:input type="checkbox" value="true" path="barbecue"/>
				</label>
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
		<form:input type="hidden" path="userId" />

		<div class="control-group">
			<label class="control-label" for="active">Estado</label>
			<div class="controls">
				<form:select path="active">
					<form:option label="Activa" value="true"/>
					<form:option label="Inactiva" value="false"/>
				</form:select>
			</div>
		</div>
		<c:if test="${publicationForm.publicationId != -1}">		
			<a href="<c:url value="editPhotos">
				<c:param name="publicationId" value="${publicationForm.publicationId}" />
			</c:url>
				">Editar Imagenes
			</a>
		</c:if>
		<c:if test="${publicationForm.publicationId == -1}">
			<b>Debe guardar la publicaci&oacute;n para agregar im&aacute;genes a la misma</b>
		</c:if>
		
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Guardar</button>
		</div>

	</fieldset>
</form:form>
<%@ include file="../footer.jsp" %>