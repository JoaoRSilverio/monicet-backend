package pt.geniusgrow.monicet.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.dtos.requests.RegistrationRequestDto;
import pt.geniusgrow.monicet.interfaces.services.RegistrationService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.application.Role;
import pt.geniusgrow.monicet.security.ERoles;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
   @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = Routes.WEB_REGISTER, produces = "application/json"
    ,method = {RequestMethod.POST}
    )
    @ResponseBody
    public UserDto register(@RequestBody RegistrationRequestDto registration){
        Set<Role> roles = new HashSet<>();
        Role userRole = new Role();
        userRole.setName(ERoles.USER);
        roles.add(userRole);
        final ApplicationUser newUser =
                new ApplicationUser(
                        registration.getUsername(),
                        registration.getEmail(),
                        registration.getPassword(),
                        roles
                        );

        return registrationService.registerNewUser(newUser);
    }
}
