package mangopot_backend.mangopot_backend.project.controller;

import lombok.Data;
import mangopot_backend.mangopot_backend.project.vo.PositionPair;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class ProjectForm {

    @NotNull
    String locName;

    @NotNull
    String userNickName;

    @NotNull
    LocalDate deadline;

    @NotNull
    String title;

    @NotNull
    String context;

    @NotNull
    ArrayList<String> interest;

    @NotNull
    ArrayList<PositionPair> position;



}
