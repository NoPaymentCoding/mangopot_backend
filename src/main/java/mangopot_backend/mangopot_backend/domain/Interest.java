package mangopot_backend.mangopot_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "interest_info")
@Data
@ToString
//@AllArgsConstructor
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
