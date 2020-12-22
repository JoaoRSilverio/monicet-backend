package pt.geniusgrow.monicet.models.common;

import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @WhenCreated
    Timestamp whenCreated;
    @WhenModified
    Timestamp whenUpdated;
}
