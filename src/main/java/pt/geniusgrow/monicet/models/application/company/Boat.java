package pt.geniusgrow.monicet.models.application.company;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Table(name = "monicet_boat")
@Entity
public class Boat extends BaseEntity {
    private String name;
    private Integer length;
    private Float power;
    private Float height;

    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    public Boat() {
    }

    public Boat(String name, Integer length, Float power,Float height) {
        this.name = name;
        this.length = length;
        this.power = power;
        this.height = height;
    }

}
