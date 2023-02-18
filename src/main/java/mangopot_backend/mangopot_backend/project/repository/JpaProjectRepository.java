package mangopot_backend.mangopot_backend.project.repository;

import mangopot_backend.mangopot_backend.location.Location;
import mangopot_backend.mangopot_backend.position.Position;
import mangopot_backend.mangopot_backend.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findById(Long id);

    List<Project> findByLocation(Location location);
}
