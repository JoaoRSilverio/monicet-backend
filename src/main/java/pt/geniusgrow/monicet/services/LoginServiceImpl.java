package pt.geniusgrow.monicet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pt.geniusgrow.monicet.dtos.UserDto;
import pt.geniusgrow.monicet.dtos.responses.LoginResponseDto;
import pt.geniusgrow.monicet.interfaces.services.LoginService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.repositories.UserRepo;
import pt.geniusgrow.monicet.security.ApplicationUserPrincipal;
import pt.geniusgrow.monicet.security.JWTUtil;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepo userRepo;

    @Override
    public LoginResponseDto getAccessAndRefreshTokens(Authentication authentication) {
        JWTUtil jwtUtil= new JWTUtil();
        ApplicationUserPrincipal userPrincipal = (ApplicationUserPrincipal) authentication.getPrincipal();
        String acessToken = jwtUtil.generateAccessToken(userPrincipal.getUsername());
        String refreshToken = jwtUtil.generateRefreshToken(userPrincipal.getUsername());
        ApplicationUser user = userRepo.getUserByEmail(userPrincipal.getUsername());
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(acessToken);
        loginResponseDto.setRefreshToken(refreshToken);
        loginResponseDto.setProfile(new UserDto(user.getName(), user.getEmail()));
        return loginResponseDto;
    }
}
