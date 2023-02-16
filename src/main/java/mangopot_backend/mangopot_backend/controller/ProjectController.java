package mangopot_backend.mangopot_backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mangopot_backend.mangopot_backend.domain.Project;
import mangopot_backend.mangopot_backend.service.ProjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        //interest, position create method 추가해야 함

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

}
