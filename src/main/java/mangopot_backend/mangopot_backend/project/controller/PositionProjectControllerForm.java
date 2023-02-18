package mangopot_backend.mangopot_backend.project.controller;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PositionProjectControllerForm {
    @NotNull
    List<String> positionNames;
}
