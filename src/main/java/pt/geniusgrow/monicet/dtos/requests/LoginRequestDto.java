package pt.geniusgrow.monicet.dtos.requests;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String email;
    private String password;
}
