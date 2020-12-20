package pt.geniusgrow.monicet.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.geniusgrow.monicet.models.User;

@RestController
public class publicController {
    @RequestMapping("/user")
    public User user(){
        final User usr = new User();
        usr.setEmail("emaill");
        usr.setName("nameee");
        return usr;
    }

}
