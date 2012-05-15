package zonaProp.web.command;

import zonaProp.transfer.bussiness.OperationType;
import zonaProp.transfer.bussiness.PropertyType;
import zonaProp.transfer.bussiness.Search;
import zonaProp.transfer.bussiness.User;

public class SearchForm {

	String max = null;
	String min = null;
	OperationType operationType = null;
	PropertyType propertyType = null;
	User publisher = null;
	boolean ascending = true;

	
	public User getPublisher() {
		return publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		if (max != null)
			this.max = max.trim();
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		if (min != null)
			this.min = min.trim();
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public Search build() {
		return new Search(min==null || min.isEmpty() ? null : Double.parseDouble(min),
				max==null || max.isEmpty() ? null : Double.parseDouble(max), operationType,
				propertyType, ascending, publisher);
	}
}
