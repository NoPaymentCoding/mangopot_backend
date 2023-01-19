package mangopot_backend.mangopot_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mangopot_backend.mangopot_backend.domain.Location;
import mangopot_backend.mangopot_backend.domain.Project;
import mangopot_backend.mangopot_backend.domain.UserInfo;
import mangopot_backend.mangopot_backend.repository.JpaLocationRepository;
import mangopot_backend.mangopot_backend.repository.JpaProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    final private JpaProjectRepository projectRepository;
    final private LocationService locationService;
    final private UserInfoService userInfoService;

    @Override
    public boolean createProject(String title, String context, LocalDate deadline, String userName, String locName) {
        Optional<Location> location = locationService.findLocation(locName);
        List<Location> locationList = locationService.findAllLocation();
        log.info("location list: " + locationList);
        if (location.isEmpty()) { //지역명이 잘못된 경우
            log.info("loc_name: " + locName);
            log.info("지역명 오류");
            return false;
        }

        Optional<UserInfo> user = userInfoService.findUser(userName);

        if (user.isEmpty()) {
            log.info("유저가 없음");
            return false;
        }

        Project project = Project.builder()
                .title(title)
                .context(context)
                .deadline(deadline)
                .userInfo(user.get())
                .location(location.get())
                .build();

        projectRepository.save(project);
        return true;
    }

    @Override
    public Optional<Project> updateProject(String title, String context, LocalDate deadline, String userName, String locName) {
        return Optional.empty();
    }

    @Override
    public boolean deleteProject(Long pro_id) {
        return false;
    }

    public void clearRepo(){
        projectRepository.deleteAll();
    }

    public long RepoCount() {
        return projectRepository.count();
    }
}
