package cbd.com.vn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CourseImage {

    @EmbeddedId
    private CourseImageId id;

}
