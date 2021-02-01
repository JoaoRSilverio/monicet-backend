package pt.geniusgrow.monicet.models.application.address;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "monicet_locality")
@AllArgsConstructor
@Entity
public class Locality extends BaseEntity {
    private String code;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Municipality municipality;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locality")
    private Set<ZipCode> parishes = new HashSet<>();
}
