package pt.geniusgrow.monicet.dtos.requests;

import lombok.Getter;

@Getter
public class RegistrationRequestDto {
    private String username;
    private String email;
    private String password;
}
