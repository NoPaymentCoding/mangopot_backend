package mangopot_backend.mangopot_backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity //db와 매칭될 데이터베이스 임을 의미
@Table(name = "user_info")//db 내 테이블 이름을 의미
@Getter
@ToString // to_string method 자동 생성
@NoArgsConstructor //파라미터없는 기본 생성자 생성
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA 사용시 필요
    @Column(name = "user_id")
    private  Long userId;

    private String email;

    private String nickname;

    @Column(name = "user_info")
    private String userInfo;

    private  String sns;

    @Column(name = "is_git")
    private  boolean isGit;

    @Column(name = "is_deleted")
    private  boolean isDeleted;

    private Long exp;

    @Column(name = "profile_img")
    private  String profileImg;

    @Builder //생성자나 수정자 대신에 사용
    private UserInfo(String email, String nickname, String userInfo, String sns) { //필수로 입력되어야 하는 것들
        this.exp = 0L;
        this.profileImg = "/";

        this.email = email;
        this.nickname = nickname;
        this.userInfo = userInfo;
        this.sns = sns;
    }

}