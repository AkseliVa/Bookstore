package hh.sof03.Bookstore.webController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

public class CategoryRestController {

	@Autowired
	private CategoryRepository repository;

	//Returns a list of "Category"-entities fetched from the categoryrepository and passes them of in JSON-format
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategorysRest() {
		return (List<Category>) repository.findAll();
	}

	//Returns the "Category"-entity corresponding to the "id"-value given as a parameter
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
		return repository.findById(categoryId);
	}

	//Saves the parameter "category" using POST-method
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
		return repository.save(category);
	}
}
