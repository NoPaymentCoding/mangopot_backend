package mangopot_backend.mangopot_backend.controller;

import lombok.Data;
import mangopot_backend.mangopot_backend.domain.Location;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

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
