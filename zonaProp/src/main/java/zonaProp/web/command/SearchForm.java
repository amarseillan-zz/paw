package zonaProp.web.command;

import zonaProp.model.Search;
import zonaProp.model.publication.OperationType;
import zonaProp.model.publication.PropertyType;
import zonaProp.model.user.User;

public class SearchForm {

	String max = null;
	String min = null;
	OperationType operationType = null;
	PropertyType propertyType = null;
	User publisher = null;
	boolean ascending = true;
	String page = null;
	String pageSize = null;
	
	public SearchForm() {
	}
	
	public SearchForm(String max, String min, OperationType operationType,
			PropertyType propertyType, User publisher, boolean ascending,
			String page, String pageSize) {
		super();
		this.max = max;
		this.min = min;
		this.operationType = operationType;
		this.propertyType = propertyType;
		this.publisher = publisher;
		this.ascending = ascending;
		this.page = page;
		this.pageSize = pageSize;
	}

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

	public Integer getPageValue(){
		return this.page==null || this.page.isEmpty() ? 1 : Integer.parseInt(this.page);
	}
	
	public String getPage(){
		return page;
	}
	
	public void setPage(String page){
		this.page = page;
	}
	
	public String getPageSize(){
		return pageSize;
	}
	
	public Integer getPageSizeValue(){
		return this.pageSize==null || this.pageSize.isEmpty() ? 50 : Integer.parseInt(this.pageSize);
	}
	
	public void setPageSize(String pageSize){
		this.pageSize = pageSize;
	}
	
	public Search build() {
		return new Search(min==null || min.isEmpty() ? null : Double.parseDouble(min),
				max==null || max.isEmpty() ? null : Double.parseDouble(max), operationType,
				propertyType, ascending, publisher);
	}
}
