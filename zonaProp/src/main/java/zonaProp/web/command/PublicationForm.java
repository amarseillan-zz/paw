package zonaProp.web.command;

import java.util.ArrayList;
import java.util.List;

import zonaProp.model.publication.Environment;
import zonaProp.model.publication.OperationType;
import zonaProp.model.publication.PropertyServices;
import zonaProp.model.publication.PropertyType;
import zonaProp.model.publication.Publication;

public class PublicationForm {

	private int publicationId;
	private String address;
	private String city;
	private String price;
	private int environments;
	private String covered;
	private String uncovered;
	private String age;
	
	List<Environment> environmentList;
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
		environmentList = new ArrayList<Environment>();
		
		description = "";
		active = true;
		reserved = false;

		propertyType = null;
		operationType = null;

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
		environmentList = p.getEnvironmentList();

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
				Integer.parseInt(age), propertyServices, description, active, reserved, environmentList);
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

	public List<Environment> getEnvironmentList() {
		return environmentList;
	}

	public void setEnvironmentList(List<Environment> environmentList) {
		this.environmentList = environmentList;
	}


}
