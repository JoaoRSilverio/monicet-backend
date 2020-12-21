package pt.geniusgrow.monicet.models.cms;

import io.ebean.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.geniusgrow.monicet.models.common.BaseEntity;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class NewsArticle extends BaseEntity {
    private String title;
    private String body;
    private List<String> tags = new ArrayList<>();
}
