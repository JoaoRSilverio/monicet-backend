package pt.geniusgrow.monicet.models.application;

import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;

import javax.persistence.*;
import java.security.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "monicet_users")
@AllArgsConstructor
@Entity
public class ApplicationUser extends BaseEntity {
    private String name;
    private String email;
    private String password;
}
