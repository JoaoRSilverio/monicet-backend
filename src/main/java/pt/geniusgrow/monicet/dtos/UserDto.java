package pt.geniusgrow.monicet.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pt.geniusgrow.monicet.models.application.Role;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String email;
    private String password;
    private PersonDto person;
    private Set<Role> roles;
}
