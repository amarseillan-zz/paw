package zonaProp.transfer.bussiness;

import java.util.List;

import zonaProp.services.PhotoService;
import zonaProp.services.UserService;

public class Publication {

	private int publicationId;
	private int userId;
	private String address;
	private String city;
	private float price;
	private int environments;
	private float covered;
	private float uncovered;
	private int age;
	private boolean cable;
	private boolean phone;
	private boolean pool;
	private boolean living;
	private boolean paddle;
	private boolean barbecue;
	private String description;
	private boolean active;

	
	private PropertyType propertyType;
	private OperationType operationType;
	
	private User publisher=null;

	private List<Photo> photos=null;
	
	
	public Publication(int publicationId, int userId, PropertyType propertyType,
			OperationType operationType, String address, String city, float price,
			int environments, float covered, float uncovered, int age,
			boolean cable, boolean phone, boolean pool, boolean living,
			boolean paddle, boolean barbecue, String description, boolean active) {
		super();
		this.publicationId = publicationId;
		this.userId = userId;
		this.address = address;
		this.city = city;
		this.price = price;
		this.environments = environments;
		this.covered = covered;
		this.uncovered = uncovered;
		this.age = age;
		this.cable = cable;
		this.phone = phone;
		this.pool = pool;
		this.living = living;
		this.paddle = paddle;
		this.barbecue = barbecue;
		this.description = description;
		this.active = active;
		
		this.propertyType= propertyType;
		this.operationType = operationType;
	}

	

	
	
	public int getPublicationId() {
		return publicationId;
	}

	public int getUserId() {
		return userId;
	}
	
	public PropertyType getPropertyType(){
		return propertyType;
	}

	public OperationType getOperationType(){
		return operationType;
	}
	
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public float getPrice() {
		return price;
	}

	public int getEnvironments() {
		return environments;
	}

	public float getCovered() {
		return covered;
	}

	public float getUncovered() {
		return uncovered;
	}

	public int getAge() {
		return age;
	}

	public boolean isCable() {
		return cable;
	}

	public boolean isPhone() {
		return phone;
	}

	public boolean isPool() {
		return pool;
	}

	public boolean isLiving() {
		return living;
	}

	public boolean isPaddle() {
		return paddle;
	}

	public boolean isBarbecue() {
		return barbecue;
	}

	public String getDescription() {
		return description;
	}

	public User getPublisher(){
		if(publisher==null){
			UserService us = UserService.getInstance();
			publisher=us.getUser(userId);
		}
		
		return publisher;
	}
	
	public List<Photo> getPhotos(){
		if(photos==null){
			PhotoService ps=PhotoService.getInstance();
			photos=ps.getPhotosByPublication(this);
		}
		
		return photos;
	}
	
	public boolean isActive(){
		return active;
	}
	
}
