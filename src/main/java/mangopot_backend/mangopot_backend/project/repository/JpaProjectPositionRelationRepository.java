package mangopot_backend.mangopot_backend.project.repository;

import mangopot_backend.mangopot_backend.project.domain.Project;
import mangopot_backend.mangopot_backend.project.domain.ProjectPositionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaProjectPositionRelationRepository extends JpaRepository<ProjectPositionRelation, Long> {
//    @Query(value = "select p from Project as p join ProjectPositionRelation as ppr" +
//            " on p.prjId=ppr.project.prjId where ppr.position.posId = :positionId")
//    List<Project> findByPosition(@Param("positionId") int positionId);

    @Query(value = "select p from Project as p join ProjectPositionRelation as pir" +
            " on p.prjId=pir.project.prjId where pir.position.posId in (:posiritons)")
    List<Project> findByPositionId(@Param("posiritons") List<Integer> positions);
}
