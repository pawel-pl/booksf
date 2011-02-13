package ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


public class ExportPath {

	private List<String> pathList = new ArrayList<String>();
	
	private List<String> pathListEmpty = new ArrayList<String>();
	
	private ExportType exportType;
	
	private String contentSeparator;
	
	private List<SelectItem> contentSeparatorsList;
	
	private List<String> selectedColumns;
	
	{
		pathListEmpty.add("one");
	}
	
	public List<String> getPathListEmpty() {
		return pathListEmpty;
	}

	public void setPathListEmpty(List<String> pathListEmpty) {
		this.pathListEmpty = pathListEmpty;
	}

	public List<String> getPathList() {
		return pathList;
	}

	public void setPathList(List<String> pathList) {
		this.pathList = pathList;
	}

	public void exportPathToCSV(){
		System.out.println("Export to CSV");
	}
	
	public void printPath(){
		System.out.println("Print paths");
	}
	
	public void initializePaths(){
		System.out.println("Initialize Paths");
	}

	public ExportType getExportType() {
		System.out.println("GET ExportType: "+exportType);
		return exportType;
	}

	public void setExportType(ExportType exportType) {
		System.out.println("Set ExportType: "+exportType);
		this.exportType = exportType;
	}

	public String getContentSeparator() {
		return contentSeparator;
	}

	public void setContentSeparator(String contentSeparator) {
		this.contentSeparator = contentSeparator;
	}

	public List<String> getSelectedColumns() {
		return selectedColumns;
	}

	public void setSelectedColumns(List<String> selectedColumns) {
		this.selectedColumns = selectedColumns;
	}

	public List<SelectItem> getContentSeparatorsList() {
		
		String[] selectors = {";",",","."};
		contentSeparatorsList = new ArrayList<SelectItem>();
		for(String selector : selectors){
			contentSeparatorsList.add(new SelectItem(selector, selector));
		}
		
		return contentSeparatorsList;
	}

	public void setContentSeparatorsList(List<SelectItem> contentSeparatorsList) {
		this.contentSeparatorsList = contentSeparatorsList;
	}
	
	
}

