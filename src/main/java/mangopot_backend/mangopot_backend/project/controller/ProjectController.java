package mangopot_backend.mangopot_backend.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mangopot_backend.mangopot_backend.project.domain.Project;
import mangopot_backend.mangopot_backend.project.service.ProjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    @ResponseBody
    @PostMapping()
    public ResponseEntity createProject(@Valid @RequestBody ProjectForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Optional<Project> project = projectService.createProject(form.title, form.context, form.deadline, form.userNickName, form.locName);

        if (project.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        boolean projectInterestRelationResult = projectService.createProjectInterestRelation(form.interest, project);
        if (!projectInterestRelationResult) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        boolean projectPositionRelationResult = projectService.createProjectPositionRelation(form.position, project);
        if (!projectPositionRelationResult) {
            return new ResponseEntity("position 문제", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity allProject() {
        List<Project> projectAll = projectService.findProjectAll();
        return new ResponseEntity(projectAll, HttpStatus.OK);
    }
/*
    @GetMapping("/location/{locName}")
    public ResponseEntity locationProject(@PathVariable String locName) {
        List<Project> projectByLocation = projectService.findProjectByLocation(locName);

        return new ResponseEntity(projectByLocation, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/position")
    public ResponseEntity positionProject(@RequestBody PositionProjectControllerForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        List<Project> projectList = projectService.findProjectByPosition(form.positionNames);
        return new ResponseEntity(projectList, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/interest")
    public ResponseEntity interestProject(@RequestBody InterestProjectControllerForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        List<Project> projectList = projectService.findProjectByInterest(form.interestNames);
        return new ResponseEntity(projectList, HttpStatus.OK);
    }

 */
}
