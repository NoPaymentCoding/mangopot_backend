package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.controller.PositionPair;
import mangopot_backend.mangopot_backend.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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

    //project-interest 생성
    public boolean createProjectInterestRelation(List<String> interestName, Optional<Project> project);

    public boolean createProjectPositionRelation(List<PositionPair> position, Optional<Project> project);

    public List<Project> findProjectByUser();

    public List<Project> findProjectByInterest(String interestName);
    public List<Project> findProjectByLocation();



}
