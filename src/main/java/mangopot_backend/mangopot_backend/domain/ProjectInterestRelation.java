package mangopot_backend.mangopot_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "project_interest_relation")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectInterestRelation {

    @Id
    @ManyToOne
    @JoinColumn(name = "prj_id")
    private Project project;

    @Id
    @ManyToOne
    @JoinColumn(name = "in_id")
    private Interest interest;
}
