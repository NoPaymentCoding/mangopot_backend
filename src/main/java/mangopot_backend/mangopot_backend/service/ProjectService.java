package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.domain.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProjectService {
    //project 생성
    public void createProject(String title, String context, LocalDateTime due_date, Location location);

    //project 수정
    public Optional<Project> updateProject(String title, String context, LocalDateTime due_date, Location location);

    //project 삭제
    public boolean deleteProject(Long pro_id);

    //project 조회




}
