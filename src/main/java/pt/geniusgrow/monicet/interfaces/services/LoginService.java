package pt.geniusgrow.monicet.interfaces.services;

import org.springframework.security.core.Authentication;

import pt.geniusgrow.monicet.dtos.entities.company.UserDto;
import pt.geniusgrow.monicet.dtos.responses.LoginResponseDto;

public interface LoginService {
    public LoginResponseDto getAccessAndRefreshTokens(Authentication authentication);

    public UserDto createUser(UserDto user);
}
