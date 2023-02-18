package mangopot_backend.mangopot_backend.location;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LocationForm {
    @NotNull
    String locName;
}
