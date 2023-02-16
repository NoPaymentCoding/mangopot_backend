package mangopot_backend.mangopot_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "project_position_relation")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProjectPositionRelationId.class)
public class ProjectPositionRelation {
    @Id
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "prj_id")
    private Project project;

    @Id
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pos_id")
    private Position position;

    private int total;
}
