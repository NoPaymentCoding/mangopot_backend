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
@Table(name = "location_info")
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

}
