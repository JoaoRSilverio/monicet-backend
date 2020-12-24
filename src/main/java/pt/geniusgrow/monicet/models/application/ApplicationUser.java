package pt.geniusgrow.monicet.models.application;

import io.ebean.Model;
import io.ebean.annotation.Index;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "monicet_users")
@AllArgsConstructor
@Entity
public class ApplicationUser extends BaseEntity {
    private String name;
    @Index
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();
}
