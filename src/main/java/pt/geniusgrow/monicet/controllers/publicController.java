package pt.geniusgrow.monicet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.geniusgrow.monicet.models.User;
import pt.geniusgrow.monicet.repositories.UserRepo;

import java.util.logging.Logger;

@RestController
public class publicController {
    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
    @GetMapping("/user")
    public User user(){
        final User user = new User();
        user.setName("example");
        user.setEmail("examplemail");
        try {
            final Long id = userRepo.saveUser(user);
            return user;
        } catch (Exception e){
            System.out.println("failed to save");
        }
        return null;
    }

}
