package zonaProp.model.publication;

public enum PropertyType {
	HOUSE("Casa"), DEPARTMENT("Deparamento");

	private String name;

	
	
	private PropertyType(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}

}
