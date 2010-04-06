package bookshelf.model.object;

import java.util.List;

public class SelectedBooksDTO {
	
	private Long bookId;
	
	private List<Book> books;
	
	private List<Long> selectedBooks;

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Long> getSelectedBooks() {
		return selectedBooks;
	}

	public void setSelectedBooks(List<Long> selectedBooks) {
		this.selectedBooks = selectedBooks;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "FreeBooksDTO [books=" + books
				+ ", selectedBooks=" + selectedBooks + "]";
	}
	
}
