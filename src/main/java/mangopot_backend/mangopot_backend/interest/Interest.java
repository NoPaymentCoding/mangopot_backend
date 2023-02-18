package mangopot_backend.mangopot_backend.interest;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "interest_info")
@Data
@NoArgsConstructor
public class Interest {

    @Id
    @GeneratedValue
    private int inId;

    private String name;
    private String logoImg;

    public Interest(String name, String logoImg) {
        this.name = name;
        this.logoImg = logoImg;
    }

}
