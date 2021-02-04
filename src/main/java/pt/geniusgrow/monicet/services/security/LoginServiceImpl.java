package pt.geniusgrow.monicet.services.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pt.geniusgrow.monicet.dtos.entities.company.UserDto;
import pt.geniusgrow.monicet.dtos.responses.LoginResponseDto;
import pt.geniusgrow.monicet.interfaces.repositories.company.UserRepository;
import pt.geniusgrow.monicet.interfaces.services.LoginService;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.application.Role;
import pt.geniusgrow.monicet.models.application.company.Person;
import pt.geniusgrow.monicet.models.common.ERoles;
import pt.geniusgrow.monicet.security.ApplicationUserPrincipal;
import pt.geniusgrow.monicet.security.JWTUtil;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public LoginResponseDto getAccessAndRefreshTokens(Authentication authentication) {
        JWTUtil jwtUtil = new JWTUtil();
        ApplicationUserPrincipal userPrincipal = (ApplicationUserPrincipal) authentication.getPrincipal();
        String acessToken = jwtUtil.generateAccessToken(userPrincipal.getUsername());
        String refreshToken = jwtUtil.generateRefreshToken(userPrincipal.getUsername());
        ApplicationUser user = userRepo.getUserByEmail(userPrincipal.getUsername());
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(acessToken);
        loginResponseDto.setRefreshToken(refreshToken);
        loginResponseDto.setProfile(user.getDto());
        return loginResponseDto;
    }

    @Override
    public UserDto createUser(UserDto userdto) {
        ApplicationUser user = userRepo.getUserByEmail(userdto.getEmail());
        if (user != null) {
            throw new IllegalArgumentException("Já existe um user com esse email!");
        }

        Set<Role> roles = new HashSet<>();
        Role userRole = new Role(ERoles.USER); 
        roles.add(userRole);
        final Person person = new Person();
        final ApplicationUser newUser = new ApplicationUser(userdto.getEmail(), userdto.getPassword(), person, roles);
        person.setUser(newUser);
        newUser.setPassword(bCryptPasswordEncoder.encode(userdto.getPassword()));
        userRepo.saveUser(newUser);
        
        return newUser.getDto();
    }

}
