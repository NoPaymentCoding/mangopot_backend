package mangopot_backend.mangopot_backend.repository;

import mangopot_backend.mangopot_backend.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectRepository extends JpaRepository<Project, Long> {

}
