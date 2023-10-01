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

	//REST-service to get all the categories from the database in JSON format
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategorysRest() {
		return (List<Category>) repository.findAll();
	}

	//REST-service to get a single categoy from the database in JSON format using its id
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {
		return repository.findById(categoryId);
	}

	//REST-service to save a single category into the database
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {
		return repository.save(category);
	}
}
