package pt.geniusgrow.monicet.models.application;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class IssuerToken {
    @Id
    private Long id;
    @ManyToOne
    private ApplicationUser applicationUser;

    private String issuer;

}
