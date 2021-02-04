package pt.geniusgrow.monicet.dtos.entities.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.dtos.entities.AddressDto;

@NoArgsConstructor
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
