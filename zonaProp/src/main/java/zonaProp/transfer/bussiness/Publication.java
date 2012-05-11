package zonaProp.transfer.bussiness;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Entity;

@Entity
public class Publication extends PersistentEntity {

	private String address;
	private String city;
	private double price;
	private int environments;
	private double covered;
	private double uncovered;
	private int age;
	private String description;
	private boolean active;

	List<PropertyServices> propertyServices;

	private PropertyType propertyType;
	private OperationType operationType;

	private User publisher;

	private List<Photo> photos = new ArrayList<Photo>();

	public Publication() {
		super(0);
	}

	public Publication(int publicationId, User publisher,
			PropertyType propertyType, OperationType operationType,
			String address, String city, double price, int environments,
			double covered, double uncovered, int age,
			List<PropertyServices> propertyServices, String description,
			boolean active) {
		super(publicationId);

		this.publisher = publisher;
		this.address = address;
		this.city = city;
		this.price = price;
		this.environments = environments;
		this.covered = covered;
		this.uncovered = uncovered;
		this.age = age;
		this.propertyServices = propertyServices;
		this.description = description;
		this.active = active;

		this.propertyType = propertyType;
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

		this.propertyType = p.getPropertyType();
		this.operationType = p.getOperationType();

	}

	public Photo getPhotoById(int imageId) {
		// TODO Auto-generated method stub
		return null;
	}
}
