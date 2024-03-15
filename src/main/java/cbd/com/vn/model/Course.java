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
public class Course {
    @Id
    private UUID id;
    private String title;
    private String description;

//    @ManyToMany
//    @JoinTable(name = "course_benefit",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "benefit_id"))
//    private List<Benefit> benefits;

}
