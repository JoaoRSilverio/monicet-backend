package pt.geniusgrow.monicet.dtos.entities.company;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.application.Role;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    @Deprecated
    private String username;

    private String email;
    private String password;
    private PersonDto person;
    private Set<Role> roles;

}
