package mangopot_backend.mangopot_backend.interest;

import mangopot_backend.mangopot_backend.interest.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaInterestRepository extends JpaRepository<Interest, Integer> {
    Optional<Interest> findByName(String name);

    @Query(value = "select i from Interest as i where i.name in (:names)")
    List<Interest> findByNames(@Param("names") List<String> names);

    @Query(value = "select i.inId from Interest as i where i.name in (:names)")
    List<Integer> findInterestIdByNames(@Param("names") List<String> names);

}
