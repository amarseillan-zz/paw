package zonaProp.transfer.bussiness;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import zonaProp.validators.LengthValidator;
import zonaProp.validators.NotNullValidator;

@Entity
public class Publication extends PersistentEntity {

	private String address;
	private String city;
	private double price;
	private int environments;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="publicationId")
	private List<Environment> environmentList;

	private double covered;
	private double uncovered;
	private int age;
	private String description;
	private boolean active;
	private boolean reserved;
	private int access;

	@ElementCollection(targetClass = PropertyServices.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "property_services")
	@Column(name = "services")
	List<PropertyServices> propertyServices;

	@Enumerated(EnumType.ORDINAL)
	private PropertyType propertyType;
	@Enumerated(EnumType.ORDINAL)
	private OperationType operationType;

	@ManyToOne
	private User publisher;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Photo> photos = new ArrayList<Photo>();

	public Publication() {
	}

	public Publication(int publicationId, PropertyType propertyType,
			OperationType operationType, String address, String city,
			double price, int environments, double covered, double uncovered,
			int age, List<PropertyServices> propertyServices,
			String description, boolean active, boolean reserved, int access,
			List<Environment> environmentList) {
		super(publicationId);
		setAddress(address);
		setCity(city);
		setPrice(price);
		setEnvironments(environments);
		setCovered(covered);
		setUncovered(uncovered);
		setAge(age);
		setPropertyServices(propertyServices);
		setDescription(description);
		setActive(active);
		setReserved(reserved);
		setPropertyType(propertyType);
		setOperationType(operationType);
		setAccess(access);
	}

	private void setAddress(String address) {
		new LengthValidator("direccion", 1, 30).check(address);
		this.address = address;
	}

	private void setCity(String city) {
		new LengthValidator("ciudad", 1, 30).check(city);
		this.city = city;
	}

	private void setPrice(double price) {
		this.price = price;
	}

	private void setEnvironments(int environments) {
		this.environments = environments;
	}

	private void setCovered(double covered) {
		this.covered = covered;
	}

	private void setUncovered(double uncovered) {
		this.uncovered = uncovered;
	}

	private void setAge(int age) {
		this.age = age;
	}

	private void setPropertyServices(List<PropertyServices> propertyServices) {
		this.propertyServices = propertyServices;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setActive(boolean active) {
		this.active = active;
	}

	private void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	private void setAccess(int access) {
		this.access = access;
	}

	private void setPropertyType(PropertyType propertyType) {
		new NotNullValidator("tipo de propiedad");
		this.propertyType = propertyType;
	}

	private void setOperationType(OperationType operationType) {
		new NotNullValidator("tipo de operacion");
		this.operationType = operationType;
	}

	public List<PropertyServices> getPropertyServices() {
		return propertyServices;
	}

	public int getUserId() {
		return publisher.getId();
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public double getPrice() {
		return price;
	}

	public int getEnvironments() {
		return environments;
	}

	public double getCovered() {
		return covered;
	}

	public double getUncovered() {
		return uncovered;
	}

	public int getAge() {
		return age;
	}

	public String getDescription() {
		return description;
	}

	public User getPublisher() {
		return publisher;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public boolean isActive() {
		return active;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void deletePhoto(Photo photo) {
		photos.remove(photo);
	}

	public void addPhoto(Photo image) {
		photos.add(image);
	}

	public void update(Publication p) {
		this.publisher = p.getPublisher();
		this.address = p.getAddress();
		this.city = p.getCity();
		this.price = p.getPrice();
		this.environments = p.getEnvironments();
		this.covered = p.getCovered();
		this.uncovered = p.getUncovered();
		this.age = p.getAge();
		this.propertyServices = p.getPropertyServices();
		this.description = p.getDescription();
		this.active = p.isActive();
		this.reserved = p.isReserved();

		this.propertyType = p.getPropertyType();
		this.operationType = p.getOperationType();

	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
		publisher.addPublication(this);
	}

	public int getAccess() {
		return access;
	}

	public synchronized void access() {
		access++;
	}

	public void addEnvironment(Environment env) {
		environmentList.add(env);
	}

	public List<Environment> getEnvironmentList() {
		return environmentList;
	}

	public void deleteEnvironment(Environment e) {
		environmentList.remove(e);
	}

}
