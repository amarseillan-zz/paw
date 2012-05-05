package zonaProp.transfer.bussiness;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class Photo {

	private int id;
	private int publicationId;
	private InputStream inputStream;

	public Photo(int id, int publicationId, InputStream iS) {
		super();
		this.id = id;
		setPublicationId(publicationId);
		setInputStream(iS);
	}
	

	private void setInputStream(InputStream iS) {
		this.inputStream = iS;		
	}

	private void setPublicationId(int id){
		this.publicationId = id;
	}

	public int getId() {
		return id;
	}
	
	public int getPublicationId() {
		return publicationId;
	}
	

	public InputStream getInputStream() {
		return this.inputStream;
	}


	public byte[] getImageBytes() {		
		try {
			InputStream is = this.getInputStream();
			byte[] resp = IOUtils.toByteArray(is);
			is.close();
			return resp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	public int getSize() {
		try {
			InputStream is = this.getInputStream();
			byte[] resp = IOUtils.toByteArray(is);
			is.reset();
			is.close();
			return resp.length;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
