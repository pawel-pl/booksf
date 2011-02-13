package ejb.bean.dto;

import org.hibernate.validator.Length;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;

/**
 * DTO object which transfers data required to search product 
 *
 */
public class SearchDataDTO {

	@NotEmpty
	@Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
	@Length(min=3,max=20)
	private String name;
	
	@NotNull
    @Min(1)
    @Max(999)
	private Integer quantity;
	
	private Long supplier;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getSupplier() {
		return supplier != null && supplier == 0 ? null : supplier;
	}

	public void setSupplier(Long supplier) {
		this.supplier = supplier;
	}
	
}
