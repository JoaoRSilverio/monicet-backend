package pt.geniusgrow.monicet.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequestDto {
    private String name;
    private String firstName;
    private String lastName;
    private String occupation;
    private String companyName;
    private String email;
}
