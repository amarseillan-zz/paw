package zonaProp.web.command;

import java.util.ArrayList;
import java.util.List;

import zonaProp.transfer.bussiness.OperationType;
import zonaProp.transfer.bussiness.PropertyServices;
import zonaProp.transfer.bussiness.PropertyType;
import zonaProp.transfer.bussiness.Publication;

public class PublicationForm {

	private int publicationId;
	private String address;
	private String city;
	private String price;
	private int environments;
	private String covered;
	private String uncovered;
	private String age;
	private int access;
	private String kitchen;
	private String dinningRoom;
	private String room;

	List<PropertyServices> propertyServices;

	private String description;
	private boolean active;
	private boolean reserved;

	private PropertyType propertyType;
	private OperationType operationType;

	public PublicationForm() {
		publicationId = 0;
		address = "";
		city = "";
		price = "";
		environments = 0;
		covered = "";
		uncovered = "";
		age = "";

		propertyServices = new ArrayList<PropertyServices>();

		description = "";
		active = true;
		reserved = false;

		propertyType = null;
		operationType = null;
		access = 0;

		kitchen = "";
		dinningRoom = "";
		room = "";
	}

	public PublicationForm(Publication p) {
		publicationId = p.getId();
		address = p.getAddress();
		city = p.getCity();
		price = String.valueOf((int) p.getPrice());
		environments = p.getEnvironments();
		covered = String.valueOf(p.getCovered());
		uncovered = String.valueOf(p.getUncovered());
		age = String.valueOf(p.getAge());

		propertyServices = p.getPropertyServices();

		description = p.getDescription();
		active = p.isActive();
		reserved = p.isReserved(); 

		propertyType = p.getPropertyType();
		operationType = p.getOperationType();
		access = p.getAccess();

		kitchen = String.valueOf(p.getKitchen());
		dinningRoom = String.valueOf(p.getDinningRoom());
		room = String.valueOf(p.getRoom());
	}

	public List<PropertyServices> getPropertyServices() {
		return propertyServices;
	}

	public void setPropertyServices(List<PropertyServices> propertyServices) {
		this.propertyServices = propertyServices;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Publication build() {
		return new Publication(publicationId, propertyType, operationType,
				address, city, Double.parseDouble(price), environments,
				Double.parseDouble(covered), Double.parseDouble(uncovered),
				Integer.parseInt(age), propertyServices, description, active, reserved,
				access, Integer.valueOf(kitchen), Integer.valueOf(dinningRoom),
				Integer.valueOf(room));
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getEnvironments() {
		return environments;
	}

	public void setEnvironments(int environments) {
		this.environments = environments;
	}

	public String getCovered() {
		return covered;
	}

	public void setCovered(String covered) {
		this.covered = covered;
	}

	public String getUncovered() {
		return uncovered;
	}

	public void setUncovered(String uncovered) {
		this.uncovered = uncovered;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}
	
	public boolean isReserved() {
		return reserved;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getDinningRoom() {
		return dinningRoom;
	}

	public void setDinningRoom(String dinningRoom) {
		this.dinningRoom = dinningRoom;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}
