package zonaProp.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import zonaProp.model.photo.Photo;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealEstate other = (RealEstate) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		return true;
	}
	
	
}
