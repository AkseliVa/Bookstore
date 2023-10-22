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
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnBook() {
		List<Category> categories = repository.findByName("Horror");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getBooks()).hasSize(1);
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Religion");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		Category category = new Category("Sports");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		
		List<Category> categories = repository.findByName("Sports");
		assertThat(categories).hasSize(1);
		
		repository.delete(category);
		
		List<Category> categories2 = repository.findByName("Sports");
		assertThat(categories2).hasSize(0);
	}
}