package com.examportal;

import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserService userService;

		User user = new User();

		user.setEmail("chetan@gmail.com");
		user.setFirstName("Chetan");
		user.setLastName("Chauhan");
		user.setUsername("Chetan0408");
		user.setPhone("8273241498");
		user.setPassword("abc@123");
		user.setProfile("mypic.png");

		Role role = new Role();
		role.setRoleId(1L);
		role.setRoleName("ADMIN");

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole1 = new UserRole();
		userRole1.setRole(role);
		userRole1.setUser(user);

		userRoleSet.add(userRole1);

		this.userService.createUser(user,userRoleSet);



	}
}
