package mangopot_backend.mangopot_backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProjectPositionRelationId implements Serializable {
    private Long project;
    private int position;
}
