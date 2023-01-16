package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.domain.Project;
import mangopot_backend.mangopot_backend.repository.JpaProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    final private JpaProjectRepository projectRepository;

    @Override
    public void createProject(String title, String context, LocalDateTime due_date, Location location) {
        Project project = new Project(title, context, due_date, location);
        projectRepository.save(project);
    }

    @Override
    public Optional<Project> updateProject(String title, String context, LocalDateTime due_date, Location location) {
        return Optional.empty();
    }

    @Override
    public boolean deleteProject(Long pro_id) {
        return false;
    }
}
