package pt.geniusgrow.monicet.models.application.address;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.ebean.annotation.DbJson;
import io.ebean.annotation.Index;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;
import pt.geniusgrow.monicet.models.common.LocalizedString;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "monicet_country")
@AllArgsConstructor
@Entity
public class Country extends BaseEntity {
    @Index
    private String acronym3;
    private String acronym2;

    @DbJson
    private LocalizedString name;
    @DbJson
    private LocalizedString nationality;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
    private Set<District> districts = new HashSet<>();
}
