package zonaProp.web.command;

import zonaProp.transfer.bussiness.OperationType;
import zonaProp.transfer.bussiness.PropertyType;
import zonaProp.transfer.bussiness.Publication;

public class PublicationForm {

	private int publicationId;
	private int userId;
	private String address;
	private String city;
	private String price;
	private int environments;
	private String covered;
	private String uncovered;
	private String age;
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

	public PublicationForm() {
		publicationId = -1;
		userId = -1;
		address = "";
		city = "";
		price = "";
		environments = 0;
		covered = "";
		uncovered = "";
		age = "";
		cable = false;
		phone = false;
		pool = false;
		living = false;
		paddle = false;
		barbecue = false;
		description = "";
		active = true;

		propertyType = null;
		operationType = null;
	}

	public PublicationForm(Publication p) {
		publicationId = p.getId();
		userId = p.getUserId();
		address = p.getAddress();
		city = p.getCity();
		price = String.valueOf((int) p.getPrice());
		environments = p.getEnvironments();
		covered = String.valueOf(p.getCovered());
		uncovered = String.valueOf(p.getUncovered());
		age = String.valueOf(p.getAge());
		cable = p.isCable();
		phone = p.isPhone();
		pool = p.isPool();
		living = p.isLiving();
		paddle = p.isPaddle();
		barbecue = p.isBarbecue();
		description = p.getDescription();
		active = p.isActive();

		propertyType = p.getPropertyType();
		operationType = p.getOperationType();
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

	public Publication build() {
		return new Publication(publicationId, userId, propertyType,
				operationType, address, city, Double.parseDouble(price),
				environments, Double.parseDouble(covered), Double
						.parseDouble(uncovered), Integer.parseInt(age),
				cable, phone, pool, living, paddle, barbecue, description,
				active);
	}

	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isCable() {
		return cable;
	}

	public void setCable(boolean cable) {
		this.cable = cable;
	}

	public boolean isPhone() {
		return phone;
	}

	public void setPhone(boolean phone) {
		this.phone = phone;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public boolean isPaddle() {
		return paddle;
	}

	public void setPaddle(boolean paddle) {
		this.paddle = paddle;
	}

	public boolean isBarbecue() {
		return barbecue;
	}

	public void setBarbecue(boolean barbecue) {
		this.barbecue = barbecue;
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
}
