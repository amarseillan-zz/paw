package zonaProp.web.converter;

import org.springframework.core.convert.converter.Converter;

import zonaProp.transfer.bussiness.PropertyType;


public class PropertyTypeConverter implements Converter<String, PropertyType> {

	public PropertyType convert(String arg0) {
		int num=Integer.valueOf(arg0);
		if(num==-1){
			return null;
		}
		return PropertyType.values()[num-1];
	}

}
