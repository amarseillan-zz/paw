package zonaProp.transfer.bussiness;

import java.util.LinkedList;

public class Search {
	private Integer min=null;
	private Integer max=null;
	private OperationType operationType=null;
	private PropertyType propertyType=null;
	private boolean ascending=true;
	
	public Search(Integer min, Integer max, OperationType operationType,
			PropertyType propertyType, boolean ascending) {
		super();
		this.min = min;
		this.max = max;
		this.operationType = operationType;
		this.propertyType = propertyType;
		this.ascending = ascending;
	}
	
	public String statment(){
		LinkedList<String> l = new LinkedList<String>();
		if(propertyType!=null){
			l.add("type = " + propertyType);
		}
		if(operationType!=null){
			l.add("operation_type = " + operationType);
		}
		if(max!=null){
			l.add("price <= " + max);
		}
		if(min!=null){
			l.add("price >= " + min);
		}
		String aux = "SELECT * FROM PUBLICATION";
		if(l.size()>0){
			int i=0;
			while(i<l.size()){
				if(i==0){
					aux+=" where ";
				}else{
					aux+=" and ";
				}
				aux+=l.get(i++);
			}
		}
		aux+=" order by price";
		aux+=ascending?" ASC":" DESC";
		
		return aux;
	}
}
