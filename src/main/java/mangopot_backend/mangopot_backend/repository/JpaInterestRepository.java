package mangopot_backend.mangopot_backend.repository;

import mangopot_backend.mangopot_backend.domain.Interest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaInterestRepository extends JpaRepository<Interest, Integer> {
    Optional<Interest> findByName(String name);
}
