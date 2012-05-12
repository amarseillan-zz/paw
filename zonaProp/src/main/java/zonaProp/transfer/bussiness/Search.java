package zonaProp.transfer.bussiness;


public class Search {
	private Double min=null;
	private Double max=null;
	private OperationType operationType=null;
	private PropertyType propertyType=null;
	private boolean ascending=true;
	private User publisher=null;

	public Search(Double min, Double max, OperationType operationType,
			PropertyType propertyType, boolean ascending, User publisher) {
		super();
		this.min = min;
		this.max = max;
		this.operationType = operationType;
		this.propertyType = propertyType;
		this.ascending = ascending;
		this.publisher = publisher;
	}

	public boolean isAll(){
		return min==null && max==null && operationType == null && propertyType ==null && publisher==null;
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
