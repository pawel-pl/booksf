package test;

import java.awt.Color;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.CustomExpression;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;

public class Test {

	public void buildReport2() throws Exception {

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
  		
 		AbstractColumn countCol = ColumnBuilder.getNew()		//creates a new instance of a ColumnBuilder
			.setCustomExpression(
                new CustomExpression() {
                        public Object evaluate(Map fields, Map variables, Map parameters) {
                                //Integer count = (Integer) variables.get("REPORT_COUNT");
                                return (Integer) variables.get("REPORT_COUNT");
                        }

                        public String getClassName() {
                                return Integer.class.getName();
                        }

                }
			)
			.setTitle("Count")											//the title for the column
			.setWidth(55)									//the width of the column
			.build();	
 		
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
 		drb.addColumn(countCol);
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
		drb.setTemplateFile(System.getProperty("user.dir")+"\\src\\test\\reportTemp.jrxml");
		drb.addAutoText(AutoText.AUTOTEXT_CREATED_ON, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT,AutoText.PATTERN_DATE_DATE_TIME);
		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_OF_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_LEFT,45,40);
		drb.setPrintBackgroundOnOddRows(true);
 		DynamicReport dr = drb.build();	//Finally build the report!
 		
		JRDataSource ds = new JRBeanCollectionDataSource(MyBean.getBeans());    //Create a JRDataSource, the Collection used
		                                                                                                //here contains dummy hardcoded objects...

		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);    //Creates the JasperPrint object, we pass as a Parameter
		                                                                                                //the DynamicReport, a new ClassicLayoutManager instance (this
		                                                                                                //one does the magic) and the JRDataSource
		JasperViewer.viewReport(jp);	
	}
	
	public void buildReport() throws Exception {

		DynamicReportBuilder drb = new DynamicReportBuilder();
		drb.setTitle("November 2006 sales report")		//defines the title of the report
		        .setSubtitle("The items in this report correspond "
		                        +"to the main products: DVDs, Books, Foods and Magazines")
		        .setDetailHeight(15)		//defines the height for each record of the report
		        .setMargins(30, 20, 30, 15)		//define the margin space for each side (top, bottom, left and right)
		        .setColumnsPerPage(1);		//defines columns per page (like in the telephone guide)

		/**
		 * Note that we still didn't call the build() method
		 */

		/**
		 * Column definitions. We use a new ColumnBuilder instance for each
		 * column, the ColumnBuilder.getNew() method returns a new instance
		 * of the builder
		 */
		AbstractColumn columnState = ColumnBuilder.getNew()		//creates a new instance of a ColumnBuilder
		        .setColumnProperty("state", String.class.getName())		//defines the field of the data source that this column will show, also its type
		        .setTitle("State")		//the title for the column
		        .setWidth(85)		//the width of the column
		        .build();		//builds and return a new AbstractColumn

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
		drb.setUseFullPageWidth(true);  //we tell the report to use the full width of the page. this rezises
		                                //the columns width proportionally to meat the page width.
		drb.setPrintBackgroundOnOddRows(true);
		drb.setPrintColumnNames(true);
		DynamicReport dr = drb.build(); //Finally build the report!

		JRDataSource ds = new JRBeanCollectionDataSource(MyBean.getBeans());    //Create a JRDataSource, the Collection used
		                                                                                                //here contains dummy hardcoded objects...

		JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);    //Creates the JasperPrint object, we pass as a Parameter
		                                                                                                //the DynamicReport, a new ClassicLayoutManager instance (this
		                                                                                                //one does the magic) and the JRDataSource
		JasperViewer.viewReport(jp);		//finally display the report report
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		Test t = new Test();
		t.buildReport2();

	}

}
