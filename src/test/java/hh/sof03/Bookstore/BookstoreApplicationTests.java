package hh.sof03.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.Bookstore.webController.BookController;
import hh.sof03.Bookstore.webController.BookRestController;
import hh.sof03.Bookstore.webController.CategoryController;
import hh.sof03.Bookstore.webController.CategoryRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController bcontroller;
	@Autowired
	private BookRestController brcontroller;
	
	@Autowired
	private CategoryController ccontroller;
	@Autowired
	private CategoryRestController crcontroller;

	@Test
	public void contextLoads() {
		assertThat(bcontroller).isNotNull();
		assertThat(brcontroller).isNotNull();
		
		assertThat(ccontroller).isNotNull();
		assertThat(crcontroller).isNotNull();
	}

}
