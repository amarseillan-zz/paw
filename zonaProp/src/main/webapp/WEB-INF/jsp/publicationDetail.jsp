
<%@ include file="header.jsp" %>


						<form class="form-horizontal" method="POST" action="publicationDetail">
							<fieldset>
								<div class="control-group">
									<label class="control-label" for="type">Tipo de propiedad</label>
										<div class="controls">
              								<select id="type">
    								            <option>something</option>
    								            <option>2</option>
     								  	        <option>3</option>
    								            <option>4</option>
    								            <option>5</option>
     								         </select>
      							      </div>
								</div>
								<div class="control-group">
									<label class="control-label" for="operation_type">Tipo de operaci&oacute;n</label>
										<div class="controls">
              								<select id="operation_type">
    								            <option>something</option>
    								            <option>2</option>
     								  	        <option>3</option>
    								            <option>4</option>
    								            <option>5</option>
     								         </select>
      							      </div>
								</div>
								<div class="control-group">
        						    <label class="control-label" for="address">Direcci&oacute;n</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" id="address" value="${publication.address}">
       							    </div>
          						</div>
								<div class="control-group">
        						    <label class="control-label" for="city">Ciudad</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" id="city" value="${publication.city}">
       							    </div>
          						</div>
								<div class="control-group">
        						    <label class="control-label" for="price">Precio</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" id="price" value="${publication.price}">
       							    </div>
          						</div>
								<div class="control-group">
									<label class="control-label" for="environments">N&uacute;mero de ambientes</label>
										<div class="controls">
              								<select id="enviroments">
    								            <option>1</option>
    								            <option>2</option>
     								  	        <option>3</option>
    								            <option>4</option>
    								            <option>5</option>
    								            <option>6</option>
    								            <option>7</option>
     								         </select>
      							      </div>
								</div>
								<div class="control-group">
        						    <label class="control-label" for="covered">Superficie cubierta</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" id="covered" value="${publication.covered}">
       							    </div>
          						</div>
								<div class="control-group">
        						    <label class="control-label" for="uncovered">Superficie descubierta</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" id="uncovered" value="${publication.uncovered}">
       							    </div>
								</div>
								<div class="control-group">
        						    <label class="control-label" for="age">Antigüedad</label>
        						    <div class="controls">
        						    	<input type="text" class="input-xlarge" id="age" value="${publication.age}">
       							    </div>
          						</div>
          						<div class="control-group">
            						<label class="control-label" for="cable">Cable</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" id="cable" checked="${publication.cable}">
              							</label>
            						</div>
          						</div>
          						<div class="control-group">
            						<label class="control-label" for="phone">Tel&eacute;fono</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" id="phone" checked="${publication.phone}">
              							</label>
            						</div>
          						</div>
          						<div class="control-group">
            						<label class="control-label" for="pool">Pileta</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" id="pool" checked="${publication.pool}">
              							</label>
            						</div>
          						</div>
          						<div class="control-group">
            						<label class="control-label" for="living">Sal&oacute;n</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" id="living" checked="${publication.living}">
              							</label>
            						</div>
          						</div>
          						<div class="control-group">
            						<label class="control-label" for="paddle">Cancha de paddle</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" id="paddle" checked="${publication.paddle}">
              							</label>
            						</div>
          						</div>
          						<div class="control-group">
            						<label class="control-label" for="barbecue">Quincho</label>
            						<div class="controls">
              							<label class="checkbox">
                							<input type="checkbox" id="barbecue" checked="${publication.barbecue}">
              							</label>
            						</div>
          						</div>
								<div class="control-group">
           							<label class="control-label" for="description">Descripci&oacute;n</label>
            						<div class="controls">
              							<textarea class="input-xlarge" id="description" rows="3" style="margin-top: 0px; margin-bottom: 0px; height: 54px; margin-left: 0px; margin-right: 0px; width: 533px; ">${publication.description}</textarea>
         							</div>
        					  	</div>
        					  	
								<input type="hidden" name="publicationId" value="${publication.publicationId}" />
								<input type="hidden" name="userId" value="${publication.userId}" />
								<div class="form-actions">
            						<button type="submit" class="btn btn-primary">Guardar</button>
            						<button class="btn">Cancelar</button>
          						</div>
							</fieldset>
						</form>
<%@ include file="footer.jsp" %>


						
						
						<%-- 	
	private String age;
	private boolean cable;
	private boolean phone;
	private boolean pool;
	private boolean living;
	private boolean paddle;
	private boolean barbecue;
	private String description;--%>