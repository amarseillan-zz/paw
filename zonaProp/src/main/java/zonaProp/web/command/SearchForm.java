package zonaProp.web.command;

import zonaProp.transfer.bussiness.OperationType;
import zonaProp.transfer.bussiness.PropertyType;
import zonaProp.transfer.bussiness.Search;

public class SearchForm {

	String max = null;
	String min = null;
	OperationType operationType = null;
	PropertyType propertyType = null;
	boolean ascending = true;

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
		return new Search(min.isEmpty() ? null : Integer.valueOf(min),
				max.isEmpty() ? null : Integer.valueOf(max), operationType,
				propertyType, ascending);
	}
}
