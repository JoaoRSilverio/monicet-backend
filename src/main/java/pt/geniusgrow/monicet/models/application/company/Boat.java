package pt.geniusgrow.monicet.models.application.company;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pt.geniusgrow.monicet.dtos.entities.company.BoatDto;
import pt.geniusgrow.monicet.models.common.BaseEntity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    public void edit(BoatDto dto) {
        this.name = dto.getName();
        this.length = dto.getLength();
        this.power = dto.getPower();
        this.height = dto.getHeight();
    }

    public BoatDto getDto() {
        BoatDto dto = new BoatDto();

        dto.setId(getId().toString());
        dto.setName(name);
        dto.setLength(length);
        dto.setHeight(height);
        dto.setPower(power);

        return dto;
    }

}
