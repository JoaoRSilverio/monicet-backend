package pt.geniusgrow.monicet.dtos.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddressDto {
    private String country;
    private String district;
    private String municipality;
    private String locality;
    private String zipCode;
    private String street;
    private String number;
}
