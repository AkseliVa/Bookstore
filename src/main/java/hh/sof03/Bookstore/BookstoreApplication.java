package hh.sof03.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return(args) -> {
			log.info("Save some books");
			brepository.save(new Book("kakka", "pissa", 1999, "12345", 15));
			brepository.save(new Book("kirja", "kirjanen", 2000, "54321", 1));
			brepository.save(new Book("demo", "demonen", 1111, "1", 5));
			
			log.info("Save some categories");
			Category category1 = new Category("Horror");
			crepository.save(category1);
			Category category2 = new Category("Romance");
			crepository.save(category2);
			Category category3 = new Category("Comic");
			crepository.save(category3);
			
			log.info("Fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			log.info("Fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
		};
	}

}
