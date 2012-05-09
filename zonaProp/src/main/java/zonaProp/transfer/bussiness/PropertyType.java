package zonaProp.transfer.bussiness;

public enum PropertyType {
	HOUSE("Casa",1), DEPARTMENT("Deparamento",2);

	private String name;
	private int number;

	
	
	private PropertyType(String name, int number) {
		this.name = name;
		this.number=number;
	}

	public int getNumber() {
		return this.number;
	}
	
	public String toString(){
		return name;
	}


	public String getName() {
		return this.name;
	}

}
