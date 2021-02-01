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
@Table(name = "monicet_address")
@AllArgsConstructor
@Entity
public class Address extends BaseEntity {

    private String street;
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    private ZipCode zipCode;
}
