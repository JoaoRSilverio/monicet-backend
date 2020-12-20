package pt.geniusgrow.monicet.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "monicet_users")
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
