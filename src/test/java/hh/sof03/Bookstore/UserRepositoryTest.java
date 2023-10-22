package hh.sof03.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.Bookstore.domain.User;
import hh.sof03.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnRole() {
		List<User> users = repository.findByRole("USER");
		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("user");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("test", "$2a$10$zVhl5zIp0NtwOBlQxsP9OOb4z3f4VrkdMlpE9Wo.65M34Pgx8tv.", "USER",
				"test@gmail.com");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = new User("testi", "abcd", "TEST", "user@gmail.com");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
		
		List<User> users = repository.findByRole("TEST");
		assertThat(users).hasSize(1);
		
		repository.delete(user);
		
		List<User> users2 = repository.findByRole("TEST");
		assertThat(users2).hasSize(0);
	}
}
