package mangopot_backend.mangopot_backend.project.repository;

import mangopot_backend.mangopot_backend.interest.Interest;
import mangopot_backend.mangopot_backend.project.domain.Project;
import mangopot_backend.mangopot_backend.project.domain.ProjectInterestRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaProjectInterestRelationRepository extends JpaRepository<ProjectInterestRelation, Integer>{
//    List<Project> findByInterest(Interest interest);
    @Query(value = "select p from Project as p join ProjectInterestRelation as pir" +
            " on p.prjId=pir.project.prjId where pir.interest.inId in (:interests)")
    List<Project> findByInterest(@Param("interests") List<Integer> interests);

}
