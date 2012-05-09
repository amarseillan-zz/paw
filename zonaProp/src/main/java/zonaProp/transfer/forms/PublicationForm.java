package zonaProp.transfer.forms;


import zonaProp.transfer.bussiness.Publication;

@Deprecated
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
		
		
	}

	public PublicationForm(int publicationId, int userId, int type,
			int operation_type, String address, String city, String price,
			int environments, String covered, String uncovered, String age,
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
		
	
	}

	public PublicationForm(Publication p) {
		publicationId = p.getPublicationId();
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
		
	}

	public Publication toBussiness(){
		return null;
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
	
	public boolean isActive(){
		return active;
	}
}
