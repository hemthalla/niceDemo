package nice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import nice.models.Task;
import nice.models.TaskRepository;
import nice.models.User;
import nice.models.UserRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Bean
	CommandLineRunner init(UserRepository userDao, TaskRepository taskRepo) {
		return (evt) -> {
			userDao.save(new User("niceUser1"));
			userDao.save(new User("niceUser2"));
			userDao.save(new User("niceUser3"));
			
			taskRepo.save(new Task("ProjectManagement","Project management","In Progress","niceUser1"));
			taskRepo.save(new Task("Development","Development","In Progress","niceUser2"));
			taskRepo.save(new Task("Testing","Testing","In Progress","niceUser3"));
		};
	}
	

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    } 
}