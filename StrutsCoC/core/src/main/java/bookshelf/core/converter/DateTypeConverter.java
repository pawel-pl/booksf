package bookshelf.core.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

import bookshelf.core.validation.ValidationHelper;

public class DateTypeConverter extends StrutsTypeConverter{

	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");
	
	private static final Logger LOG = Logger.getLogger(DateTypeConverter.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map map, String[] as, Class class1) {
		
		
		String dateString = as[0];
		
		if(dateString == null){
			return null;
		}
		
		if(!ValidationHelper.isDateValidPattern(dateString)){
			throw new TypeConversionException("String doesn't match date pattern");
		}
		
		Date date = null;
		try {
			date = FORMATTER.parse(dateString);
		} catch (ParseException e) {
			LOG.fatal("Parse date exception", e);
		}
		
		return date;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map map, Object obj) {
		
		if(obj == null){
			return null;
		}
		
		if(!(obj instanceof Date)){
			throw new TypeConversionException("Object must be of type Date but is" +
					" "+obj.getClass().getSimpleName());
		}
		
		return FORMATTER.format((Date)obj);
	}

}
