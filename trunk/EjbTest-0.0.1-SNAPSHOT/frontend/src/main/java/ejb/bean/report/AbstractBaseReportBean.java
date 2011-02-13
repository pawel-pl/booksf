package ejb.bean.report;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import ejb.reports.ReportConfigUtil;

public abstract class AbstractBaseReportBean {
  public enum ExportOption {PDF, HTML, EXCEL, RTF}
  
  private ExportOption exportOption;
  
  private final String COMPILE_DIR = "/reports/";
      
  public AbstractBaseReportBean() {
    super();
    setExportOption(ExportOption.PDF);
  }

  protected void prepareReport() throws JRException, IOException {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    
    ServletContext context = (ServletContext) externalContext.getContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
    
    ReportConfigUtil.compileReport(context, getCompileDir(), getCompileFileName());
    
    File reportFile = new File(ReportConfigUtil.getJasperFilePath(context, getCompileDir(), getCompileFileName()+".jasper"));
    
    JasperPrint jasperPrint = null;//ReportConfigUtil.fillReport(reportFile, getReportParameters(), getJRDataSource());
	try {
		jasperPrint = buildReport2(context);
	} catch (Exception e) {
		
		throw new RuntimeException(e);
	} 
    
    if(getExportOption().equals(ExportOption.HTML)) {
      ReportConfigUtil.exportReportAsHtml(jasperPrint, response.getWriter());
    }else {    
      request.getSession().setAttribute(BaseHttpServlet.DEFAULT_JASPER_PRINT_SESSION_ATTRIBUTE, jasperPrint);    
      response.sendRedirect(request.getContextPath()+"/servlets/report/"+getExportOption());
    }
    
    FacesContext.getCurrentInstance().responseComplete();
  }
  
	public JasperPrint buildReport2(ServletContext context) throws Exception {

  		Style headerStyle = new Style();  
  		headerStyle.setBackgroundColor(new Color(230,230,230));
  		headerStyle.setBorder(Border.THIN);
  		headerStyle.setBorderColor(Color.black);
  		headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
  		headerStyle.setTransparency(Transparency.OPAQUE);
  
  		Style titleStyle = new Style("titleStyle");
  		titleStyle.setHorizontalAlign(HorizontalAlign.CENTER);
  		titleStyle.setFont(null);
  		Font f = new Font();
  		f.setFontSize(15);
  		f.setFontName(Font._FONT_ARIAL);
  		titleStyle.setFont(f);
  		
  		Style amountStyle = new Style(); amountStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
  
  		/**
  		 * Creates the DynamicReportBuilder and sets the basic options for
  		 * the report
  		 */
  		DynamicReportBuilder drb = new DynamicReportBuilder();
  		drb.setTitle("November 2006 sales report")
  			.setDetailHeight(15)
  			.setMargins(30, 20, 30, 15)
  			.setDefaultStyles(titleStyle, null, headerStyle, null);
  			//.addStyle(subtitleStyleParent); //register the parent style
  
  
  		/**
  		 * Note that we didn't call the build() method yet
  		 */
  
  		/**
  		 * Column definitions. We use a new ColumnBuilder instance for each
  		 * column, the ColumnBuilder.getNew() method returns a new instance
  		 * of the builder
  		 */
 		AbstractColumn columnState = ColumnBuilder.getNew()		//creates a new instance of a ColumnBuilder
 			.setColumnProperty("state", String.class.getName())			//defines the field of the data source that this column will show, also its type
 			.setTitle("State")											//the title for the column
 			.setWidth(85)									//the width of the column
 			.build();													//builds and return a new AbstractColumn
 
 		//Create more columns
 		AbstractColumn columnBranch = ColumnBuilder.getNew()
 			.setColumnProperty("branch", String.class.getName())
 			.setTitle("Branch").setWidth(85)
 			.build();
 
 		AbstractColumn columnaProductLine = ColumnBuilder.getNew()
 			.setColumnProperty("productLine", String.class.getName())
 			.setTitle("Product Line").setWidth(85)
 			.build();
 
 		AbstractColumn columnaItem = ColumnBuilder.getNew()
 			.setColumnProperty("item", String.class.getName())
 			.setTitle("Item").setWidth(85)
 			.build();
 
 		AbstractColumn columnCode = ColumnBuilder.getNew()
 			.setColumnProperty("id", Long.class.getName())
 			.setTitle("ID").setWidth(40)
 			.build();
 
 		AbstractColumn columnaCantidad = ColumnBuilder.getNew()
 			.setColumnProperty("quantity", Long.class.getName())
 			.setTitle("Quantity").setWidth(80)
 			.build();
 
 		AbstractColumn columnAmount = ColumnBuilder.getNew()
 			.setColumnProperty("amount", Float.class.getName())
 			.setTitle("Amount").setWidth(90)
 			.setPattern("$ 0.00")		//defines a pattern to apply to the values swhown (uses TextFormat)
 			.setStyle(amountStyle)		//special style for this column (align right)
 			.build();
 
 		/**
 		 * We add the columns to the report (through the builder) in the order
 		 * we want them to appear
 		 */
 		drb.addColumn(columnState);
 		drb.addColumn(columnBranch);
 		drb.addColumn(columnaProductLine);
 		drb.addColumn(columnaItem);
 		drb.addColumn(columnCode);
 		drb.addColumn(columnaCantidad);
 		drb.addColumn(columnAmount);
 
 		/**
 		 * add some more options to the report (through the builder)
 		 */
 		drb.setUseFullPageWidth(true);	//we tell the report to use the full width of the page. this rezises
 										//the columns width proportionally to meet the page width.
 
 		//This look for the resource in the classpath
		drb.setTemplateFile(context.getRealPath("/reports/reportTemp.jrxml"));
		drb.addAutoText(AutoText.AUTOTEXT_CREATED_ON, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT,AutoText.PATTERN_DATE_DATE_TIME);
		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT,45,40);
		drb.setPrintBackgroundOnOddRows(true);
 		DynamicReport dr = drb.build();	//Finally build the report!
 		
		JRDataSource ds = new JRBeanCollectionDataSource(MyBean.getBeans());    //Create a JRDataSource, the Collection used
		                                                                                                //here contains dummy hardcoded objects...

		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);    //Creates the JasperPrint object, we pass as a Parameter
		                                                                                                //the DynamicReport, a new ClassicLayoutManager instance (this
		                                                                                                //one does the magic) and the JRDataSource
		return jp;	
	}

  public ExportOption getExportOption() {
    return exportOption;
  }

  public void setExportOption(ExportOption exportOption) {
    this.exportOption = exportOption;
  }

  protected Map<String, Object> getReportParameters() {
    return new HashMap<String, Object>();
  }

  protected String getCompileDir() {
    return COMPILE_DIR;
  }
  
  protected abstract JRDataSource getJRDataSource();

  protected abstract String getCompileFileName();

}
