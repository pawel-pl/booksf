package bookshelf.model.helper;

import java.util.List;

import bookshelf.model.object.BaseModel;

public class LogHelper {

	public static String getModelAsString(List<? extends BaseModel> model){
		
		if(model == null || model.isEmpty()){
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(model.get(0).getId());
		
		if(model.size() == 1){
			return builder.toString();
		}
		
		for (BaseModel m : model) {
			builder.append(", "+m.getId());
		}
		
		return builder.toString();
	}
}
