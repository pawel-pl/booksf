package bookshelf.model.object;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book_status")
public class BookStatus extends BaseModelImpl {

	private static final long serialVersionUID = -5032980692508514068L;

	@Column(name = "rent_time", nullable = true)
	@Temporal(value = TemporalType.DATE)
	private Date rentTime;
	
	@Column(name = "rent_days", nullable = true)
	private Integer rentDays;
	
	@Enumerated(EnumType.STRING)
	private BookState state;
	
	@OneToOne(mappedBy = "status", optional=false)
	private Book book;
	
	public BookStatus(){
		
	}

	public Date getRentTime() {
		return rentTime;
	}

	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
	}

	public Integer getRentDays() {
		return rentDays;
	}

	public void setRentDays(Integer rentDays) {
		this.rentDays = rentDays;
	}

	public BookState getState() {
		return state;
	}

	public void setState(BookState state) {
		this.state = state;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
