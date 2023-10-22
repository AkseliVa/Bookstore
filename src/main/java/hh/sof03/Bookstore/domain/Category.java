package hh.sof03.Bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Automatic unique id-value is provided
	private Long categoryid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // One of this classes entities can be attached
																// to many of book classes entities
	@JsonIgnoreProperties("category") //REST doesn't take into account this properties "category" value
	private List<Book> books;

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}

}
