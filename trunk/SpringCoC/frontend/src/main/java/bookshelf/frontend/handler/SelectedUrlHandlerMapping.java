package bookshelf.frontend.handler;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

public class SelectedUrlHandlerMapping extends DefaultAnnotationHandlerMapping {

	private Set<String> urls;

	private String[] filterUrls(String[] urlsForHandler){
	
		if(urls == null || urls.isEmpty()){
			return urlsForHandler;
		}
		
		if(urlsForHandler == null || urlsForHandler.length == 0){
			return null;
		}
		
		Set<String> filteredUrlsForHandler = new HashSet<String>();
		
		for(String url : urlsForHandler){
			if(urls.contains(url)){
				filteredUrlsForHandler.add(url);
			}
		}
		
		return filteredUrlsForHandler.isEmpty() ?
				null : filteredUrlsForHandler.toArray(new String[filteredUrlsForHandler.size()]);
	}
	
	@Override
	protected String[] determineUrlsForHandler(String beanName) {
		
		return filterUrls(super.determineUrlsForHandler(beanName));
	}

	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}

}
