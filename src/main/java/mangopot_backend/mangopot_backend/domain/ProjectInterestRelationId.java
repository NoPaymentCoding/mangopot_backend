package mangopot_backend.mangopot_backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProjectInterestRelationId implements Serializable {

    private Long project;
    private int interest;

    public ProjectInterestRelationId(Long project, int interest) {
        this.project = project;
        this.interest = interest;
    }
}
