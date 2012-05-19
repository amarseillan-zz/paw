package zonaProp.transfer.bussiness;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
public class Environment extends PersistentEntity{

	@Enumerated(EnumType.ORDINAL)
	private EnvironmentType type;
	private int width;
	private int depth;
	
	public Environment() {
		super(0);
	}
	
	public Environment(int id, EnvironmentType type, int width, int depth) {
		super(id);
		this.type = type;
		this.width = width;
		this.depth = depth;
	}

	public EnvironmentType getType() {
		return type;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}
	
	public boolean equals(Environment e){
		return e.getDepth() == depth && e.getWidth() == width && e.getType().equals(type);
	}

}
