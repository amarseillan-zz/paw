package zonaProp.transfer.bussiness;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import zonaProp.validators.LengthValidator;

@Entity
public class RealEstate extends User {
	
	private String companyName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Photo photo;
	
	public RealEstate(){
	}
	
	public RealEstate(String companyName, Photo photo, String email,
			String phone, String username, String password){
		super(email, phone, username, password);
		setCompanyName(companyName);
		setPhoto(photo);
	}
	
	public Photo getPhoto(){
		return photo;
	}
	
	public void setPhoto(Photo photo){
		this.photo = photo;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName)  {
		new LengthValidator("nombre de la compania", 3, 20).check(companyName);
		this.companyName = companyName;
	}

	@Override
	public String getCompleteName() {
		return companyName;
	}
}
