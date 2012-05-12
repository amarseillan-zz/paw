package zonaProp.transfer.bussiness;

public enum OperationType {
	SELL("Venta"), RENT("Alquiler");

	private String name;

	
	
	private OperationType(String name) {
		this.name = name;
	}
	
	
	public String getName(){
		return name;
	}

	public String toString(){
		return name;
	}

}
