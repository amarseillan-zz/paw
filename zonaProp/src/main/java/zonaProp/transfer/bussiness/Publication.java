package zonaProp.transfer.bussiness;

import java.util.List;

import zonaProp.services.ComboService;
import zonaProp.services.PhotoService;
import zonaProp.services.UserService;
import zonaProp.transfer.forms.Combo;

public class Publication {

	int publicationId;
	int userId;
	int type;
	int operation_type;
	String address;
	String city;
	float price;
	int environments;
	float covered;
	float uncovered;
	int age;
	boolean cable;
	boolean phone;
	boolean pool;
	boolean living;
	boolean paddle;
	boolean barbecue;
	String description;
	boolean active;

	private String typeDesc=null;
	private String operationTypeDesc=null;
	
	
	User publisher=null;

	List<Photo> photos=null;
	
	
	public Publication(int publicationId, int userId, int type,
			int operation_type, String address, String city, float price,
			int environments, float covered, float uncovered, int age,
			boolean cable, boolean phone, boolean pool, boolean living,
			boolean paddle, boolean barbecue, String description, boolean active) {
		super();
		this.publicationId = publicationId;
		this.userId = userId;
		this.type = type;
		this.operation_type = operation_type;
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
	}

	
	public String getTypeDesc(){
		if(typeDesc == null){
			ComboService cs = ComboService.getInstance();
			List<Combo> typeList = cs.getTypes();
			List<Combo> oTypeList = cs.getOperationTypes();
			typeDesc = typeList.get(type-1).getDescription();
			operationTypeDesc = oTypeList.get(operation_type-1).getDescription();
		}
		return typeDesc;
	}
	
	public String getOperationTypeDesc(){
		if(operationTypeDesc == null){
			ComboService cs = ComboService.getInstance();
			List<Combo> typeList = cs.getTypes();
			List<Combo> oTypeList = cs.getOperationTypes();
			typeDesc = typeList.get(type-1).getDescription();
			operationTypeDesc = oTypeList.get(operation_type-1).getDescription();
		}
		return operationTypeDesc;
	}
	
	
	public int getPublicationId() {
		return publicationId;
	}

	public int getUserId() {
		return userId;
	}

	public int getType() {
		return type;
	}

	public int getOperation_type() {
		return operation_type;
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
			photos=ps.getPhotosByPublicationId(publicationId);
		}
		
		return photos;
	}
	
	public boolean isActive(){
		return active;
	}
	
}
