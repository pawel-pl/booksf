package ejb.bean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class StringToExportTypeConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
       
    	return ExportType.valueOf(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {

        if(value instanceof String){
        	return (String)value;
        }
        
        return ((ExportType)value).name();
    }
}
