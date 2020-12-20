package pt.geniusgrow.monicet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.geniusgrow.monicet.models.User;
import pt.geniusgrow.monicet.repositories.UserRepo;

@SpringBootApplication
public class MonicetApplication {
	@Autowired
	UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(MonicetApplication.class, args);

	}



}
