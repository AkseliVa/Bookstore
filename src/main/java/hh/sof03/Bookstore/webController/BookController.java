package hh.sof03.Bookstore.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryrepository;

	//Fetches all "bookRepository":s "Book"-entities and passes them off to booklist.html
	@GetMapping("/booklist")
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();

		model.addAttribute("books", books);

		return "booklist";
	}

	//Deletes the right entity from "bookRepository" using the "id"-value
	//After this user gets redirected back to the booklist.html-page
	//User has to have "ADMIN" authority
	@GetMapping("/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:/booklist";
	}

	//Creates a new empty "Book"-entity and passes it and all the categories to addbook.html page
	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addbook";
	}

	//Saves the "Book"-entity given as a parameter and saves it to the "bookRepository"
	//After this user gets redirected to the booklist.hmtl-page
	@PostMapping("/save")
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}

	//Uses the "id"-value given as a parameter to find the corresponding book-entity
	//After this user gets directed to the editbook.html-page where they can edit the corresponding entity
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryrepository.findAll());
		return "editbook";
	}
}
