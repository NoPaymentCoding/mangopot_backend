package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.domain.Project;
import mangopot_backend.mangopot_backend.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ProjectService {
    //project 생성
    public boolean createProject(String title, String context, LocalDate deadline, String userName, String locName);

    //project 수정
    public Optional<Project> updateProject(String title, String context, LocalDate deadline, String userName, String locName);

    //project 삭제
    public boolean deleteProject(Long pro_id);

    //project 조회




}
