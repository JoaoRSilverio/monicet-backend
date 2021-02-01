package pt.geniusgrow.monicet.models.application.address;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "monicet_parish")
@AllArgsConstructor
@Entity
public class Parish extends BaseEntity {
    private String code;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Municipality municipality;
}
