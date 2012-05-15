package zonaProp.transfer.bussiness;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class PersistentEntity {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	 public PersistentEntity(int id) {
		 this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	protected void setId(int id){
		this.id=id;
	}
	
	public boolean isNew(){
		return id == 0;
	}
}
