package pt.geniusgrow.monicet.models.application;


import lombok.Getter;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;
import pt.geniusgrow.monicet.security.ERoles;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "roles")
@Entity
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoles name;

}
