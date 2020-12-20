package pt.geniusgrow.monicet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import pt.geniusgrow.monicet.models.User;
import pt.geniusgrow.monicet.repositories.UserRepo;

import java.util.logging.Logger;

@RestController
public class publicController {
    @Autowired
    UserRepo userRepo;

    @RequestMapping("/api/user")
    public User user() {
        final User user = new User();
        user.setName("example");
        user.setEmail("examplemail");
        try {
            final Long id = userRepo.saveUser(user);
            return user;
        } catch (Exception e) {
            System.out.println("failed to save");
        }
        return null;
    }
    }

