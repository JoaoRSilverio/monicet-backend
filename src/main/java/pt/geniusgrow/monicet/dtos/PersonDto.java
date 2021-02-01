package pt.geniusgrow.monicet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PersonDto {
    private String name;
    private String firstName;
    private String lastName;
    private String occupation;
    private CompanyDto company;
    private AddressDto address;
}
