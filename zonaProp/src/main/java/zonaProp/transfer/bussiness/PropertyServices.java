package zonaProp.transfer.bussiness;

public enum PropertyServices {
	CABLE("Cable"),PHONE("Telefono"),POOL("Mesa de pool"),LIVING("Sala de estar"),PADDLE("Cancha de paddle"),BARBACUE("Parrilla");
	
	private String name;
	
	private PropertyServices(String name) {
		this.name=name;
	}
	
	public String toString(){
		return name;
	}
}
