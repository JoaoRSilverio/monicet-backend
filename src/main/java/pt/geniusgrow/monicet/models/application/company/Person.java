package pt.geniusgrow.monicet.models.application.company;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pt.geniusgrow.monicet.dtos.entities.company.PersonDto;
import pt.geniusgrow.monicet.models.application.ApplicationUser;
import pt.geniusgrow.monicet.models.common.BaseEntity;

@Getter
@Setter
@Table(name = "monicet_person")
@Entity
public class Person extends BaseEntity {
    private String name;
    private String firstName;
    private String lastName;
    private String occupation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @OneToOne
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @ManyToMany
    @JoinTable(name = "skipperCompany", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> skipperCompanies;

    @ManyToMany
    @JoinTable(name = "watchmanCompany", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> watchmanCompanies;

    @ManyToMany
    @JoinTable(name = "guideCompany", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Set<Company> guideCompanies;



    public Person() {
    }

    public Person(String name, String occupation, Company company) {
        this.name = name;
        this.occupation = occupation;
        this.company = company;
    }

	public void edit(PersonDto personDto) {
        this.name = personDto.getName();
        this.firstName = personDto.getFirstName();
        this.lastName = personDto.getLastName();
        this.occupation = personDto.getOccupation();
    }
    
    public PersonDto getDto() {
        PersonDto dto = new PersonDto();

        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setName(name);
        dto.setOccupation(occupation);

        return dto;
    }
}
