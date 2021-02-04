package pt.geniusgrow.monicet.models.application.company;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.ebean.annotation.Index;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.dtos.entities.AddressDto;
import pt.geniusgrow.monicet.dtos.entities.company.CompanyDto;
import pt.geniusgrow.monicet.models.common.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "monicet_company")
@AllArgsConstructor
@Entity
public class Company extends BaseEntity {
    @Index 
    private String name;
    @Index 
    private String email;
    
    private String acronym;
    private String phone;
    private String mobile;
    private String fax;
    private String observations;
    
    //TODO
    private AddressDto address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Person> employees;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Boat> boats;

    @ManyToMany(mappedBy = "skipperCompanies")
    private Set<Person> skippers;

    @ManyToMany(mappedBy = "watchmanCompanies")
    private Set<Person> watchmen;

    @ManyToMany(mappedBy = "guideCompanies")
    private Set<Person> guides;

    public Company(String name, String email, String acronym, String phone, String mobile, String fax, String observations) {
        this.name = name;
        this.email = email;
        this.acronym = acronym;
        this.phone = phone;
        this.mobile = mobile;
        this.fax = fax;
        this.observations = observations;
        this.employees = new HashSet<>();
        this.boats = new HashSet<>();
        this.skippers = new HashSet<>();
        this.watchmen = new HashSet<>();
        this.guides = new HashSet<>();
    }

    public void edit(CompanyDto dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.acronym = dto.getAcronym();
        this.phone = dto.getPhone();
        this.mobile = dto.getMobile();
        this.fax = dto.getFax();
        this.observations = dto.getObservations();
    }

    public CompanyDto getDto() {
        CompanyDto dto = new CompanyDto();

        dto.setId(getId().toString());
        dto.setName(name);
        dto.setEmail(email);
        dto.setAcronym(acronym);
        dto.setPhone(phone);
        dto.setMobile(mobile);
        dto.setFax(fax);
        dto.setObservations(observations);
        dto.setEmployees(employees.stream().map(e -> e.getDto()).collect(Collectors.toSet()));
        dto.setBoats(boats.stream().map(b -> b.getDto()).collect(Collectors.toSet()));
        dto.setSkippers(skippers.stream().map(s -> s.getDto()).collect(Collectors.toSet()));
        dto.setWatchmen(watchmen.stream().map(w -> w.getDto()).collect(Collectors.toSet()));
        dto.setGuides(guides.stream().map(g -> g.getDto()).collect(Collectors.toSet()));

        return dto;
    }
}
