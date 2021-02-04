package pt.geniusgrow.monicet.models.application;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.ebean.annotation.Index;
import lombok.Getter;
import lombok.Setter;
import pt.geniusgrow.monicet.dtos.entities.company.UserDto;
import pt.geniusgrow.monicet.models.application.company.Person;
import pt.geniusgrow.monicet.models.common.BaseEntity;
import pt.geniusgrow.monicet.models.common.ERoles;

@Getter
@Setter
@Table(name = "monicet_user")
@Entity
public class ApplicationUser extends BaseEntity {
    @Index
    private String email;
    private String password;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL )
    private Person person;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();

    public ApplicationUser() {
    }

    public ApplicationUser(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.person = new Person();
        this.roles = roles;
    }

    public ApplicationUser(String email, String password, Person person, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.person = person;
        this.roles = roles;
    }

    public String getName() {
        return person.getName();
    }

    public void addRole(ERoles roleType) {
        if(roles.stream().anyMatch(r -> r.getName().equals(roleType))) {
            return;
        }
        roles.add(new Role(roleType));
    }

    public void removeRole(ERoles roleType) {
        Role roleToRemove = roles.stream().filter(r -> r.getName().equals(roleType)).findAny().orElse(null);
        if(roleToRemove != null) {
            roles.remove(roleToRemove);
        }
    }

    public void setRoles(Set<Role> roles) {
        if(roles == null) {
            this.roles = new HashSet<>();
        }else {
            this.roles = roles;
        }
    }

    public void edit(UserDto dto) {
        this.password = dto.getPassword();
        this.person.edit(dto.getPerson());
        this.roles = dto.getRoles();
    }

    public UserDto getDto() {
        UserDto dto = new UserDto();

        dto.setEmail(email);
        dto.setPerson(person.getDto());
        dto.setRoles(roles);

        return dto;
    }

}
