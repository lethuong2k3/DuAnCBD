package cbd.com.vn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Benefit {
    @Id
    private UUID id;
    private String title;
    private String description;

//    @ManyToMany(mappedBy = "benefits")
//    private List<Course> courses;

}
