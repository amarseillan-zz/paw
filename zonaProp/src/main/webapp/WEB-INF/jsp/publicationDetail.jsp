
<%@ include file="header.jsp" %>


<c:forEach items="${errors}" var="error">
	<p class="error">${error}</p>
</c:forEach>

<form class="form-horizontal" method="POST" action="publicationDetail">
	<fieldset>
		<div class="control-group">
			<label class="control-label" for="type">Tipo de propiedad</label>
			<div class="controls">
				<select name="type">
					<c:forEach items="${typeList}" var="propertyType">
						<option value="${propertyType.pos}">${propertyType.description}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="operation_type">Tipo
				de operaci&oacute;n
			</label>
			<div class="controls">
				<select name="operation_type">
					<c:forEach items="${oTypeList}" var="operationType">
						<option value="${operationType.pos}">${operationType.description}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="address">Direcci&oacute;n
			</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="address" maxlength="30"
					value="${publication.address}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="city">Ciudad</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="city" maxlength="30"
					value="${publication.city}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="price">Precio</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="price"
					value="${publication.price}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="environments">N&uacute;mero
				de ambientes
			</label>
			<div class="controls">
				<select name="environments">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="covered">Superficie cubierta</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="covered"
					value="${publication.covered}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="uncovered">Superficie descubierta</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="uncovered"
					value="${publication.uncovered}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="age">Antig&uuml;edad
			</label>
			<div class="controls">
				<input type="text" class="input-xlarge" name="age"
					value="${publication.age}">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="cable">Cable</label>
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="cable" value="true" <c:if test="${publication.cable}">checked="true"</c:if>">
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="phone">Tel&eacute;fono
			</label>
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="phone" value="true" <c:if test="${publication.phone}">checked="true"</c:if>">
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="pool">Pileta</label>
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="pool" value="true" <c:if test="${publication.pool}">checked="true"</c:if>">
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="living">Sal&oacute;n
			</label>
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="living" value="true" <c:if test="${publication.living}">checked="true"</c:if>">
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="paddle">Cancha de paddle</label>
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="paddle" value="true" <c:if test="${publication.paddle}">checked="true"</c:if>">
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="barbecue">Quincho</label>
			<div class="controls">
				<label class="checkbox">
					<input type="checkbox" name="barbecue" value="true" <c:if test="${publication.barbecue}">checked="true"</c:if>">
				</label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="description">Descripci&oacute;n
			</label>
			<div class="controls">
				<textarea class="input-xlarge" name="description" rows="3"
					style="margin-top: 0px; margin-bottom: 0px; height: 54px; margin-left: 0px; margin-right: 0px; width: 533px; ">${publication.description}</textarea>
			</div>
		</div>

		<input type="hidden" name="publicationId" value="${publication.publicationId}" />
		<input type="hidden" name="userId" value="${publication.userId}" />

		<a href="<c:url value=" photoUpload ">
			<c:param name="pid" value="${publication.publicationId}" />
		</c:url>
			">Editar Imagenes
		</a>

		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<button class="btn">Cancelar</button>
		</div>

	</fieldset>
</form>
<%@ include file="footer.jsp" %>