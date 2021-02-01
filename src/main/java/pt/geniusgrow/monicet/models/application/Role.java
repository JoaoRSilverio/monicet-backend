package pt.geniusgrow.monicet.models.application;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;
import pt.geniusgrow.monicet.models.common.ERoles;

@Getter
@Setter
@Table(name = "roles")
@Entity
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERoles name;

    public Role(ERoles roleType) {
        if(roleType == null){
            throw new IllegalArgumentException("Role type must be defined.");
        }
        this.name = roleType;
    }
}
