package mangopot_backend.mangopot_backend.project.service;

import mangopot_backend.mangopot_backend.project.vo.PositionPair;
import mangopot_backend.mangopot_backend.project.domain.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    //project 생성
    public Optional<Project> createProject(String title, String context, LocalDate deadline, String userName, String locName);

    //project 수정
    public Optional<Project> updateProject(String title, String context, LocalDate deadline, String userName, String locName);

    //project 삭제
    public boolean deleteProject(Long pro_id);

    //project 조회
    public Optional<Project> findProjectById(Long proId);

    public List<Project> findProjectAll();

    //project-interest 생성
    public boolean createProjectInterestRelation(List<String> interestName, Optional<Project> project);

    public boolean createProjectPositionRelation(List<PositionPair> position, Optional<Project> project);

    public List<Project> findProjectByUser();

    public List<Project> findProjectByInterest(List<String> interestNames);
    public List<Project> findProjectByLocation(String locationName);
    public List<Project> findProjectByPosition(List<String> positionName);



}
