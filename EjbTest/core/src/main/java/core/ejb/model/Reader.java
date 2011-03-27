package core.ejb.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reader implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private Y y = new Y();
    
    private int age;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Reader() {

    }

    public Reader(int age, Set<Book> books) {

	this.age = age;
	this.books = books;
	for (Book book : books) {
	    book.setReader(this);
	}
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getAge() {
	return age;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public Set<Book> getBooks() {
	return books;
    }

    public void setBooks(Set<Book> books) {
	this.books = books;
    }

}
