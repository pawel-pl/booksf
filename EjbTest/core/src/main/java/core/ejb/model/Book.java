package core.ejb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book() {

    }

    public Book(String title) {

	this.title = title;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public Reader getReader() {
	return reader;
    }

    public void setReader(Reader reader) {
	this.reader = reader;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

}
