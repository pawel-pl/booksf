package ejb.bean.dto;

import org.hibernate.validator.Length;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;

/**
 * DTO object which transfers data required to add product 
 *
 */
public class AddProductDTO extends SearchDataDTO {

	@NotNull
    @Min(1)
    @Max(9999)
	private Float price;
	
	@NotEmpty
	@Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
	@Length(min=3,max=250)
	private String description;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
