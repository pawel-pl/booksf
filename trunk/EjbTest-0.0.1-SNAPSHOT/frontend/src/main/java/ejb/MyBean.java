package ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyBean {
	
	private String state;
	private String branch;
	private String productLine;
	private String item;
	private Long id;
	private Long quantity;
	private Float amount;
	
	public MyBean(String state, String branch, String productLine, String item,
			Long id, Long quantity, Float amount) {
		super();
		this.state = state;
		this.branch = branch;
		this.productLine = productLine;
		this.item = item;
		this.id = id;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public static Collection<MyBean> getBeans(){
		
		List<MyBean> beans = new ArrayList<MyBean>();
		
		beans.add(new MyBean("state", "branch", "productLine", "item", 1l, 3l, 23.2f));
		beans.add(new MyBean("state", "branch", "productLine", "item", 1l, 3l, 23.2f));
		beans.add(new MyBean("state", "branch", "productLine", "item", 1l, 3l, 23.2f));
		beans.add(new MyBean("state", "branch", "productLine", "item", 1l, 3l, 23.2f));
		beans.add(new MyBean("state", "branch", "productLine", "item", 1l, 3l, 23.2f));
		
		return beans;
	}
}
