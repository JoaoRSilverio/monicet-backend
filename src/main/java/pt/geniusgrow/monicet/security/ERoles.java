package pt.geniusgrow.monicet.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;

import javax.persistence.Table;


public enum ERoles {
    USER,
    COLLABORATOR,
    WATCHTOWER,
    MANAGER,
    ADMIN,
    SUPER_ADMIN
}
