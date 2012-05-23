package zonaProp.model;

import zonaProp.model.publication.OperationType;
import zonaProp.model.publication.PropertyType;
import zonaProp.model.user.User;
import zonaProp.validators.PositiveValidator;

public class Search {
	private Double min = null;
	private Double max = null;
	private OperationType operationType = null;
	private PropertyType propertyType = null;
	private boolean ascending = true;
	private User publisher = null;

	public Search(Double min, Double max, OperationType operationType,
			PropertyType propertyType, boolean ascending, User publisher) {

		setMin(min);
		setMax(max);
		setOperationType(operationType);
		setPropertyType(propertyType);
		setAscending(ascending);
		setPublisher(publisher);
	}

	private void setMin(Double min) {
		if(min!=null)
			new PositiveValidator("minimo").check(min);
		this.min = min;
	}

	private void setMax(Double max) {
		if(max!=null)
			new PositiveValidator("maximo").check(max);
		this.max = max;
	}

	private void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	private void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	private void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	private void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public Double getMin() {
		return min;
	}

	public Double getMax() {
		return max;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public boolean isAscending() {
		return ascending;
	}

	public User getPublisher() {
		return publisher;
	}
	
}
