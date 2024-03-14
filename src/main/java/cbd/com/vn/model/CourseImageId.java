package cbd.com.vn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class CourseImageId implements Serializable {
    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "image_id")
    private UUID imageId;

}
