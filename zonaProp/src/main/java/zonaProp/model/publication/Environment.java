package zonaProp.model.publication;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import zonaProp.model.PersistentEntity;
import zonaProp.validators.NotNullValidator;
import zonaProp.validators.PositiveValidator;


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
		setType(type);
		setWidth(width);
		setDepth(depth);
	}

	private void setType(EnvironmentType type) {
		new NotNullValidator("tipo de ambiente").check(type);
		this.type = type;
	}

	private void setWidth(int width) {
		new PositiveValidator("ancho").check(width);
		this.width = width;
	}

	private void setDepth(int depth) {
		new PositiveValidator("largo").check(depth);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Environment other = (Environment) obj;
		if (depth != other.depth)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

}
