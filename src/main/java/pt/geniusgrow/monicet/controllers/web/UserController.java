package pt.geniusgrow.monicet.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.dtos.requests.RegistrationRequestDto;
import pt.geniusgrow.monicet.interfaces.services.RegistrationService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;

@Controller
public class UserController {
   @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = Routes.WEB_REGISTER, produces = "application/json"
    ,method = {RequestMethod.POST}
    )
    @ResponseBody
    public UserDto register(@RequestBody RegistrationRequestDto registration){

        final ApplicationUser newUser =
                new ApplicationUser(
                        registration.getUsername(),
                        registration.getEmail(),
                        registration.getPassword());

        return registrationService.registerNewUser(newUser);
    }
}
