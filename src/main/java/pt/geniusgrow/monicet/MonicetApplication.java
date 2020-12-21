package pt.geniusgrow.monicet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pt.geniusgrow.monicet.repositories.UserRepo;

@SpringBootApplication
public class MonicetApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(MonicetApplication.class, args);

	}



}
