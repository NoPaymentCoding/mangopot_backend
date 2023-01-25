package mangopot_backend.mangopot_backend.repository;

import mangopot_backend.mangopot_backend.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaPositionRepository extends JpaRepository<Position, Integer> {
    Optional<Position> findByName(String name);

}
