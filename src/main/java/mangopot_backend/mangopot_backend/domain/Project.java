package mangopot_backend.mangopot_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long prj_id;

    private String title;
    private String context;
    private LocalDateTime due_date;
    private boolean is_done;
    @GeneratedValue
    private LocalDateTime date;

    //project 외래키
    //user_info로 바꾸기
//    private User user;
    @ManyToOne
    @JoinColumn(name = "loc_id")
    private Location location;

    public Project(String title, String context, LocalDateTime due_date, Location location) {
        this.is_done = false;
        this.title = title;
        this.context = context;
        this.due_date = due_date;
        this.location = location;
    }
}
