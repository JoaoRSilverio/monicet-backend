package pt.geniusgrow.monicet.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.interfaces.services.RegistrationService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;

@Controller
@RequestMapping("/api/users")
public class UserController {
   @Autowired
    private RegistrationService registrationService;

    @PostMapping(Routes.REGISTER)
    public UserDto register(@RequestBody ApplicationUser applicationUser){
        return registrationService.registerNewUser(applicationUser);
    }
}
