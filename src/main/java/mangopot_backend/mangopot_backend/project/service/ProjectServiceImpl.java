package mangopot_backend.mangopot_backend.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mangopot_backend.mangopot_backend.interest.Interest;
import mangopot_backend.mangopot_backend.interest.InterestService;
import mangopot_backend.mangopot_backend.location.Location;
import mangopot_backend.mangopot_backend.location.LocationService;
import mangopot_backend.mangopot_backend.position.Position;
import mangopot_backend.mangopot_backend.position.PositionService;
import mangopot_backend.mangopot_backend.project.vo.PositionPair;
import mangopot_backend.mangopot_backend.project.domain.*;
import mangopot_backend.mangopot_backend.project.repository.JpaProjectInterestRelationRepository;
import mangopot_backend.mangopot_backend.project.repository.JpaProjectPositionRelationRepository;
import mangopot_backend.mangopot_backend.project.repository.JpaProjectRepository;
import mangopot_backend.mangopot_backend.userInfo.UserInfo;
import mangopot_backend.mangopot_backend.userInfo.UserInfoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    final private JpaProjectRepository projectRepository;
    final private JpaProjectInterestRelationRepository projectInterestRelationRepository;
    final private JpaProjectPositionRelationRepository projectPositionRelationRepository;
    final private InterestService interestService;
    final private PositionService positionService;
    final private LocationService locationService;
    final private UserInfoService userInfoService;



    @Override
    public Optional<Project> createProject(String title, String context, LocalDate deadline, String userName, String locName) {
        Optional<Location> location = locationService.findLocation(locName);
        if (location.isEmpty()) { //지역명이 잘못된 경우
            log.info("지역명 오류");
            return null;
        }

        Optional<UserInfo> user = userInfoService.findUser(userName);
        if (user.isEmpty()) {
            log.info("유저가 없음");
            return null;
        }

        Project project = Project.builder()
                .title(title)
                .context(context)
                .deadline(deadline)
                .userInfo(user.get())
                .location(location.get())
                .build();

        projectRepository.save(project);
        log.info("project save 완료");

        return Optional.of(project);
    }

    @Override
    public Optional<Project> updateProject(String title, String context, LocalDate deadline, String userName, String locName) {
        return Optional.empty();
    }

    @Override
    public boolean deleteProject(Long pro_id) {
        return false;
    }

    @Override
    public List<Project> findProjectAll(){
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }


    @Override
    public Optional<Project> findProjectById(Long proId) {
        Optional<Project> project = projectRepository.findById(proId);
        return project;
    }

    @Override
    public boolean createProjectInterestRelation(List<String> interestNameList, Optional<Project> project) {

        if (project.isEmpty()) {
            log.info("project 전달되지 않음");
            return false;
        }

        Iterator<String> iterator = interestNameList.iterator();

        while (iterator.hasNext()) {
            String nextInterest = iterator.next();

            Optional<Interest> interest = interestService.findInterestByName(nextInterest);

            if (interest.isEmpty()) {
                log.info("interest 이름 오류", interestNameList);
                return false;
            }
            ProjectInterestRelation projectInterestRelation = new ProjectInterestRelation(project.get(), interest.get());
            projectInterestRelationRepository.save(projectInterestRelation);
        }
        log.info("project-interest 생성 완료");
        return true;
    }

    @Override
    public boolean createProjectPositionRelation(List<PositionPair> positionPairList, Optional<Project> project) {
        //PositionPair의 first가 PositionName, seconde가 value
        if (project.isEmpty()) {
            log.info("project 전달되지 않음");
            return false;
        }
        Iterator<PositionPair> iterator = positionPairList.iterator();

        while (iterator.hasNext()) {
            PositionPair nextPosition = iterator.next();
            Optional<Position> position = positionService.findPositionByName(nextPosition.getName());
            if (position.isEmpty()) {
                log.info("해당하는 position이 없음", nextPosition.getName());
                return false;
            }
            int value = nextPosition.getValue();
            ProjectPositionRelation projectPositionRelation = new ProjectPositionRelation(project.get(), position.get(), value);
            projectPositionRelationRepository.save(projectPositionRelation);
        }

        log.info("project-position 생성 완료");
        return true;
    }

    @Override
    public List<Project> findProjectByUser() { //UserInfo가 완성되면 구현할 것
        return null;
    }

    @Override
    public List<Project> findProjectByInterest(List<String> interestNames) {
        List<Integer> interestList = interestService.findInterestIdByNames(interestNames);
        List<Project> projectList = projectInterestRelationRepository.findByInterest(interestList);

        return projectList;
    }

    @Override
    public List<Project> findProjectByLocation(String locationName) {
        Optional<Location> location = locationService.findLocation(locationName);
        if (location.isEmpty()) {
            return null;
        }
        List<Project> projectList = projectRepository.findByLocation(location.get());

        return projectList;
    }

    @Override
    public List<Project> findProjectByPosition(List<String> positionName){
        List<Integer> positionIdsByNames = positionService.findPositionIdsByNames(positionName);

        List<Project> projectList = projectPositionRelationRepository.findByPositionId(positionIdsByNames);
        return projectList;
    }

    public void clearRepo(){
        projectRepository.deleteAll();
    }

    public long RepoCount() {
        return projectRepository.count();
    }

    public void clearProjectInterestRelationRepo(){ projectInterestRelationRepository.deleteAll();}
    public void clearProjectPositionRelationRepo(){ projectPositionRelationRepository.deleteAll();}

    public long ProjectInterestRelationRepoCount(){ return projectInterestRelationRepository.count(); }
    public long ProjectPositionRelationRepoCount(){ return projectPositionRelationRepository.count(); }
}
