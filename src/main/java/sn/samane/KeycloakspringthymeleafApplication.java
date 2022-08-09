package sn.samane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = false)
public class KeycloakspringthymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakspringthymeleafApplication.class, args);
	}
//https://www.springboottutorial.com/spring-boot-with-jquery-and-bootstrap-web-jars
//https://www.thymeleaf.org/doc/articles/springsecurity.html
}
