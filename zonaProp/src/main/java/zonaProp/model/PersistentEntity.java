package zonaProp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class PersistentEntity {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	 public PersistentEntity() {
		 this.id = 0;
	}
	 
	 public PersistentEntity(int id) {
		 this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isNew(){
		return id == 0;
	}
}
