package mangopot_backend.mangopot_backend.location;

import mangopot_backend.mangopot_backend.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaLocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByName(String name);
}

