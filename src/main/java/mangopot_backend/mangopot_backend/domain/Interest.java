package mangopot_backend.mangopot_backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interest_info")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Interest {

    @Id
    @GeneratedValue
    int inId;

    String name;
    String logoImg;

    public Interest(String name, String logoImg) {
        this.name = name;
        this.logoImg = logoImg;
    }

}
