
<%@ include file="header.jsp" %>

<h2>Buscar publicaciones</h2>
<c:forEach items="${errors}" var="error">
								<p class="error">${error}</p>
							</c:forEach>
						<form class="form-horizontal" method="GET" action="publicationSearchResults">
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="type">Tipo de propiedad</label>
										<div class="controls">
              								<select name="type">
																	<option value="-1">Tipo de propiedad:</option>
              									<c:forEach items="${typeList}" var="propertyType">
    								            	<option value="${propertyType.pos}">${propertyType.description}</option>
																</c:forEach>
     								         </select>
      							      </div>
								</div>
								<div class="control-group">
									<label class="control-label" for="operation_type">Tipo de operaci&oacute;n</label>
										<div class="controls">
              								<select name="operation_type">
																	<option value="-1">Tipo de operaci&oacute;n</option>
              									<c:forEach items="${oTypeList}" var="operationType">
    								            	<option value="${operationType.pos}">${operationType.description}</option>
																</c:forEach>
     								         </select>
      							      </div>
								</div>
								<div class="control-group">
        						    <label class="control-label" for="minPrice">Desde: ($)</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" name="minPrice" value="${publication.address}">
       							    </div>
          			</div>
								<div class="control-group">
        						    <label class="control-label" for="maxPrice">Hasta: ($)</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" name="maxPrice" value="${publication.city}">
       							    </div>
          						</div>
								
          						<div class="control-group">
            						<label class="control-label" for="ascending">Ordenado ascendentemente:</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" name="ascending" checked="${publication.cable}">
              							</label>
            						</div>
          						</div>
								<div class="form-actions">
            						<button type="submit" class="btn btn-primary">Buscar</button>
          						</div>
							</fieldset>
						</form>
<%@ include file="footer.jsp" %>