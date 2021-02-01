package pt.geniusgrow.monicet.models.application.company;

import java.util.Set;

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
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Person> persons;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Boat> boats;

    @ManyToMany(mappedBy = "skipperCompanies")
    private Set<Person> skippers;

    @ManyToMany(mappedBy = "watchmanCompanies")
    private Set<Person> watchmen;

    @ManyToMany(mappedBy = "guideCompanies")
    private Set<Person> guides;
}
