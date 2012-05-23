package zonaProp.model.publication;

public enum PropertyServices {
	CABLE("Cable"), PHONE("Telefono"), POOL("Mesa de pool"), LIVING(
			"Sala de estar"), PADDLE("Cancha de paddle"), BARBACUE("Parrilla"), TENNIS(
			"Cancha de tenis"), VIGILANCE("Vigilancia nocturna"), LOUNDRY(
			"Lavadero"), SOLARIUM("Solarium");

	private String name;

	private PropertyServices(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public String toString() {
		return name;
	}
}
