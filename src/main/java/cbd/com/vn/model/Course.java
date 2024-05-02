package cbd.com.vn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
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
    @NotNull(message = "Tiêu đề không được để trống")
    private String title;
    @Size(max = 2,message = "Mô tả không được quá 2000 ký tự")
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
