package zonaProp.model.photo;


import java.io.IOException;
import java.io.InputStream;

import javax.persistence.Entity;

import org.apache.commons.io.IOUtils;
import org.hibernate.annotations.Type;

import zonaProp.model.PersistentEntity;



@Entity
public class Photo extends PersistentEntity {

	@Type(type="org.hibernate.type.BinaryType")
	byte[] data;

	public Photo(){
	}
	
	public Photo(InputStream iS) {
		try{
		data=IOUtils.toByteArray(iS);
		iS.close();
		}catch(IOException e){
			throw new IllegalArgumentException(e);
		}
	}
	
	public int getSize(){
		return data.length;
	}
	
	public byte[] getData() {
		return data;
	}
}
