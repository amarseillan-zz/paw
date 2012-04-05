package transfer.bussiness;

import java.io.InputStream;

public class Photo {

	private int id;
	private int publicationId;
	private byte[] imageBytes;
	private InputStream inputStream;

	public Photo(int id, int publicationId, byte[] imageBytes, InputStream iS) {
		super();
		this.id = id;
		setPublicationId(publicationId);
		setImageBytes(imageBytes);
		setInputStream(iS);
	}
	

	private void setInputStream(InputStream iS) {
		this.inputStream = iS;		
	}


	private void setImageBytes(byte[] bytes) {
		this.imageBytes = bytes;		
	}

	public void setPublicationId(int id){
		this.publicationId = id;
	}

	public int getId() {
		return id;
	}
	
	public int getPublicationId() {
		return publicationId;
	}
	
	public byte[] getImageBytes() {
		return imageBytes;
	}


	public int getSize() {
		return imageBytes.length * Byte.SIZE;
	}


	public InputStream getInputStream() {
		return this.inputStream;
	}


}
