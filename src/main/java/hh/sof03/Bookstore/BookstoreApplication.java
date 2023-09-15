package hh.sof03.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return(args) -> {
			log.info("Save some books");
			repository.save(new Book("kakka", "pissa", 1999, "12345", 15));
			repository.save(new Book("kirja", "kirjanen", 2000, "54321", 1));
			repository.save(new Book("demo", "demonen", 1111, "1", 5));
			
			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
