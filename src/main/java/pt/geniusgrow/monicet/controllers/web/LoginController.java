package pt.geniusgrow.monicet.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.geniusgrow.monicet.Routes;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.dtos.requests.LoginRequestDto;
import pt.geniusgrow.monicet.dtos.responses.LoginResponseDto;
import pt.geniusgrow.monicet.interfaces.services.LoginService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.repositories.UserRepo;
import pt.geniusgrow.monicet.security.ApplicationUserPrincipal;
import pt.geniusgrow.monicet.security.JWTUtil;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    LoginService loginService;

@RequestMapping(
        value = Routes.LOGIN,
        method = RequestMethod.POST
)
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
     Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
     return loginService.getAccessAndRefreshTokens(authentication);
    // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
   // SecurityContextHolder.getContext().setAuthentication(authentication);

}

}
