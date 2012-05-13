package zonaProp.transfer.bussiness;


import java.io.IOException;
import java.io.InputStream;

import javax.persistence.Entity;

import org.apache.commons.io.IOUtils;
import org.hibernate.annotations.Type;



@Entity
public class Photo extends PersistentEntity {

	@Type(type="org.hibernate.type.BinaryType")
	byte[] data;

	public Photo(){
		super(0);
	}
	
	public Photo(int id, InputStream iS) {
		super(id);
		try{
		data=IOUtils.toByteArray(iS);
		iS.close();
		}catch(IOException e){
			throw new IllegalArgumentException();
		}
	}
	
	public int getSize(){
		return data.length;
	}
	
	public byte[] getData() {
		return data;
	}
}
