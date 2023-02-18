package mangopot_backend.mangopot_backend.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mangopot_backend.mangopot_backend.interest.Interest;

import javax.persistence.*;

@Entity
@Table(name = "project_interest_relation")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProjectInterestRelationId.class)
public class ProjectInterestRelation {

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "prj_id")
    private Project project;

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "in_id")
    private Interest interest;
}
