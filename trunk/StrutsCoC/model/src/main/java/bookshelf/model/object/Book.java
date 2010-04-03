package bookshelf.model.object;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "books")
public class Book extends BaseModelImpl{

	private static final long serialVersionUID = -1408913595098307593L;

	@Column(name = "titel", nullable = false)
	private String titel;

	@Column(name = "author_name", nullable = false)
	private String authorName;
	
	@Column(name = "author_last_name", nullable = false)
	private String authorLastName;
	
	@Column(name = "year", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date year;
	
	@Column(name = "publisher", nullable = false)
	private String publisher;
	
	@ManyToOne(targetEntity = Customer.class, optional = true)
	private Customer customer;
	
    @OneToOne(targetEntity=BookStatus.class, optional = false, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="status_id")
	private BookStatus status;
	
	public Book(){
		
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

}
