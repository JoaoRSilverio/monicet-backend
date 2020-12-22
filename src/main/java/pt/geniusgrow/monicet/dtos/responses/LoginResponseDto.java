package pt.geniusgrow.monicet.dtos.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.dtos.UserDto;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDto {
    private String refreshToken;
    private String token;
    private UserDto profile;
}
