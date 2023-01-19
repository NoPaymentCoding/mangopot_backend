package mangopot_backend.mangopot_backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long prjId;

    private String title;
    private String context;
    private LocalDate deadline;
    private boolean isDone;
    private LocalDateTime date;
    private boolean isDeleted;

    //project 외래키
    //user_info로 바꾸기
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;
    @ManyToOne
    @JoinColumn(name = "loc_id")
    private Location location;

    @Builder
    public Project(String title, String context, LocalDate deadline, UserInfo userInfo, Location location) {
        this.date = LocalDateTime.now();
        this.title = title;
        this.context = context;
        this.deadline = deadline;
        this.userInfo = userInfo;
        this.location = location;
    }
}
