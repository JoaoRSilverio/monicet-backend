package pt.geniusgrow.monicet.dtos.entities.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BoatDto {
    private String id;
    private String name;
    private Integer length;
    private Float power;
    private Float height;
}
