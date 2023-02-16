package mangopot_backend.mangopot_backend.repository;

import mangopot_backend.mangopot_backend.domain.Interest;
import mangopot_backend.mangopot_backend.domain.Project;
import mangopot_backend.mangopot_backend.domain.ProjectInterestRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProjectInterestRelationRepository extends JpaRepository<ProjectInterestRelation, Integer>{

    //Project로 찾을수 없다고 뜸
    //join query 쓰도록 고치기!
    List<Project> findByInterest(Interest interest);
}
