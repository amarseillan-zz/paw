package zonaProp.web.converter;

import org.springframework.core.convert.converter.Converter;

import zonaProp.transfer.bussiness.OperationType;

public class OperationTypeConverter  implements Converter<String, OperationType>{

	public OperationType convert(String arg0) {
		int num=Integer.valueOf(arg0);
		if(num==-1){
			return null;
		}
		return OperationType.values()[num-1];
	}

}
