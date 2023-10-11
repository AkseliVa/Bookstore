package hh.sof03.Bookstore.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryrepository;

	//Fetches all "categoryRepository":s "Book"-entities and passes them off to categorylist.html
	@GetMapping("/categorylist")
	public String getList(Model model) {
		List<Category> categories = (List<Category>) categoryrepository.findAll();
		model.addAttribute("categories", categories);
		
		return "categorylist";
	}

	//Creates a new empty "Category"-entity and passes it and all the categories to addcategory.html page
	@RequestMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	//Saves the "Category"-entity given as a parameter and saves it to the "categoryRepository"
	//After this user gets redirected to the categorylist.hmtl-page
	@PostMapping("/savecategory")
	public String saveCategory(Category category) {
		categoryrepository.save(category);
		return "redirect:categorylist";
	}
	
}
