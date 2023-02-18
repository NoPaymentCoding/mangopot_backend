package mangopot_backend.mangopot_backend.location;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location_info")
@Data
@ToString
//@Builder 모든 필드가 빌더에 포함됨
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue
    private int loc_id;

    private  String name;

//    @Builder //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함됨, 필드가 하나라 필요 없음
    public Location(String name) {
        this.name = name;
    }
}
