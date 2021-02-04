package pt.geniusgrow.monicet.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.entities.company.UserDto;
import pt.geniusgrow.monicet.interfaces.services.LoginService;

@Controller
public class UserController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = Routes.WEB_REGISTER, method = RequestMethod.POST)
    public UserDto register(@RequestBody UserDto newUser) {
        return loginService.createUser(newUser);
    }
}
