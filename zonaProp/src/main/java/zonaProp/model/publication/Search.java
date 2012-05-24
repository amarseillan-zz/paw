package zonaProp.model.publication;

import zonaProp.model.user.User;
import zonaProp.validators.PositiveValidator;

public class Search {
	
	private Double min = null;
	private Double max = null;
	
	private OperationType operationType = null;
	private PropertyType propertyType = null;
	
	private boolean ascending = true;
	
	private User publisher = null;
	
	private int page = 1;
	private int pageSize = 30;

	public Search(Double min, Double max, OperationType operationType,
			PropertyType propertyType, boolean ascending, User publisher,
			int page, int pageSize) {

		setMin(min);
		setMax(max);
		setOperationType(operationType);
		setPropertyType(propertyType);
		setAscending(ascending);
		setPublisher(publisher);
		setPage(page);
		setPageSize(pageSize);
	}

	private void setMin(Double min) {
		if (min != null)
			new PositiveValidator("minimo").check(min);
		this.min = min;
	}

	private void setMax(Double max) {
		if (max != null)
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

	public void setPage(int page) {
		new PositiveValidator("pagina").check(page);
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		new PositiveValidator("tamaño de pagina").check(pageSize);
		this.pageSize = pageSize;
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

	public int getPageSize() {
		return pageSize;
	}
	
	public int from() {
		return pageSize*page;
	}

}
