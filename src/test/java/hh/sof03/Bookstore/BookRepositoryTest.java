package hh.sof03.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = repository.findByTitle("kakka");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("pissa");
	}
	
	@Test
	public void createNewBook() {
		Category category4 = new Category("Religion");
		Book book = new Book("testi", "testinen", 1, "11111", 1, category4);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		Category category5 = new Category("Sports");
		crepository.save(category5);
		Book book = new Book("testi2", "testinen2", 2, "22222", 2, category5);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		
		List<Book> books = repository.findByTitle("testi2");
		assertThat(books).hasSize(1);
		
		repository.delete(book);
		
		List<Book> books2 = repository.findByTitle("testi2");
		assertThat(books2).hasSize(0);
	}
}
