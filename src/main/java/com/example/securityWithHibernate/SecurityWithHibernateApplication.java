package com.example.securityWithHibernate;

import com.example.securityWithHibernate.Model.Users;
import com.example.securityWithHibernate.Repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.Optional;
import java.util.Set;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SecurityWithHibernateApplication implements CommandLineRunner {

	@Autowired
	UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(SecurityWithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Set<Users> users = userService.findByUserName("adminName");


		/*Set<Users> users = userService.findAllUsers();
		System.out.println(users);*/

		/*Optional<Users> user = userService.findById(1L);
		Set<Users> test = userService.findAllUsers();
		System.out.println(user);*/

		/*Optional<Users> user = userService.findByUserName("admin2");
		Set<Users> test = userService.findAllUsers();
		System.out.println(user);*/

		/*Users testNewUser = new Users();
		testNewUser.setName("admin4");
		testNewUser.setFirstName("admin4");
		testNewUser.setLastName("admin4");
		testNewUser.setUserPassword("admin1242");
		testNewUser.setEmail("asd2@mail.ru");
		//testNewUser.setId(2L);
		userService.saveUser(testNewUser);*/

		//userService.findByUserName("adminName").ifPresent(System.out::println);

		userService.deleteByUserName("admin2");

	}
}
