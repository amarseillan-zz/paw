package zonaProp.web.command;

import java.io.IOException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.PrivatePerson;
import zonaProp.transfer.bussiness.RealEstate;
import zonaProp.transfer.bussiness.User;
import zonaProp.transfer.bussiness.UserType;

public class UserForm {
	
	private String companyName;
	private CommonsMultipartFile fileData;

	private String name;
	private String lastname;
	
	private String username;
	private String password;
	private String password2;
	private String email;
	private String phone;
	
	private UserType userType;
	
	public UserForm(UserType userType){
		this.userType = userType;
	}
	
	public UserForm(){
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password1) {
		this.password = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}
	
	public User build(){
		System.out.println(userType);
		if(userType == UserType.PRIVATEUSER){
			return new PrivatePerson(name,lastname,email,phone,username,password);
		}
		else if(userType == UserType.REALESTATE){
				try {
					return new RealEstate(companyName, new Photo(fileData.getInputStream()), email, phone, username, password);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
		}
		else{
			throw new IllegalArgumentException("User type not suported.");
		}
	}
	
}
