package hh.sof03.Bookstore.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/booklist")
	public String getBooks(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		
		model.addAttribute("books", books);
		
		return "booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryrepository.findAll());
		return "addbook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryrepository.findAll());
		return "editbook";
	}
}
