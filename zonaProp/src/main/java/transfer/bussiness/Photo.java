package transfer.bussiness;

public class Photo {

	private int id;
	private int publicationId;
	private byte[] imageBytes;

	public Photo(int id, int publicationId, byte[] imageBytes) {
		super();
		this.id = id;
		setPublicationId(publicationId);
		setImageBytes(imageBytes);
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


}
