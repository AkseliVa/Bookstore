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
	@GeneratedValue(strategy = GenerationType.AUTO) // Antaa oliolle "Id"-arvoksi "categoryid" ominaisuuden ja luo ne
													// automaattisesti
	private Long categoryid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // Yksi tämän luokan olio voi olla kytköksissä moneen
																	// "Book" luokan olioon
	@JsonIgnoreProperties("category") //REST ei ota huomioon "Book" olioiden "category" ominaisuutta
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
