
<%@ include file="../header.jsp" %>

<h2>Buscar publicaciones</h2>
						
						<form:form class="form-horizontal" method="GET" action="searchResults" commandName="searchForm">
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
									<label class="control-label" for="operation_type">Tipo de operaci&oacute;n</label>
										<div class="controls">
              								<form:select path="operationType">
												<form:option value="">Tipo de operaci&oacute;n</form:option>
              									<form:options/>
     								         </form:select>
      							      </div>
								</div>
								<div class="control-group">
        						    <label class="control-label" for="minPrice">Desde: ($)</label>
        						    <div class="controls">
        						    	<form:input type="text" class="input-xlarge" path="min"/>
       							    </div>
          						</div>
								<div class="control-group">
        						    <label class="control-label" for="maxPrice">Hasta: ($)</label>
        						    <div class="controls">
        						    	<form:input type="text" class="input-xlarge" path="max"/>
       							    </div>
          						</div>
								
          						<div class="control-group">
            						<label class="control-label" for="ascending">Ordenado ascendentemente:</label>
            						<div class="controls">
              							<label class="checkbox">
                							<form:checkbox path="ascending"/>
              							</label>
            						</div>
          						</div>
								<div class="form-actions">
            						<button type="submit" class="btn btn-primary">Buscar</button>
          						</div>
							</fieldset>
						</form:form>
<%@ include file="../footer.jsp" %>