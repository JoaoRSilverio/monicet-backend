package pt.geniusgrow.monicet.dtos.entities.company;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.dtos.entities.AddressDto;

@NoArgsConstructor
@Getter
@Setter
public class CompanyDto {
    private String id;
    private String name;
    private String acronym;
    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private AddressDto address;
    private String observations;
    private Set<BoatDto> boats;
    private Set<PersonDto> employees;
    private Set<PersonDto> skippers;
    private Set<PersonDto> watchmen;
    private Set<PersonDto> guides;

    public BoatDto getBoatDtoById(String id) {
        return boats.stream().filter(b -> b.getId().equals(id)).findAny().orElse(null);
    }
}
