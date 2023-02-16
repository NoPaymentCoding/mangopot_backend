package mangopot_backend.mangopot_backend.repository;

import mangopot_backend.mangopot_backend.domain.ProjectPositionRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectPositionRelationRepository extends JpaRepository<ProjectPositionRelation, Integer> {
}
