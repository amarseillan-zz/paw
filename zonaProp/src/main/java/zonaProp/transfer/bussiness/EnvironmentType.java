package zonaProp.transfer.bussiness;

public enum EnvironmentType {
		ROOM("Cuarto"), LIVINGROOM("Living"), DINNINGROOM("Comedor"), KITCHEN("Cocina");
		
		private String name;
		
		private EnvironmentType(String name) {
			this.name = name;
		}
		
		public String getName(){
			return name;
		}
		
		public String toString(){
			return name;
		}
}
