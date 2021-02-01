package pt.geniusgrow.monicet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CompanyDto {
    private String name;
    private String acronym;
    private String email;
    private String phone;
    private String mobile;
    private String fax;
    private AddressDto address;
    private String observations;
}
