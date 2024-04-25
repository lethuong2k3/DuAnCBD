package cbd.com.vn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer status;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseImage> courseImages;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseVideo> courseVideos;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Fee> fees;
}
