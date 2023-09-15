package hh.sof03.Bookstore.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/index")
	public String Book() {
		return "bookstore";
	}
}
