package mangopot_backend.mangopot_backend.position;

import mangopot_backend.mangopot_backend.interest.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaPositionRepository extends JpaRepository<Position, Integer> {
    Optional<Position> findByName(String name);

    @Query(value = "select p from Position as p where p.name in (:names)")
    List<Interest> findByNames(@Param("names") List<String> names);

    @Query(value = "select p.posId from Position as p where p.name in (:names)")
    List<Integer> findPositionIdByNames(@Param("names") List<String> names);

}
