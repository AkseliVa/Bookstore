package hh.sof03.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	//The repository needs this function for the program to work in the way intended
	//And it has to be declared separately for it to work
	User findByUsername(String username);
	List<User> findByRole(String role);
}
