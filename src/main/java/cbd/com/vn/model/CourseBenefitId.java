package cbd.com.vn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;


@Embeddable
public class CourseBenefitId implements Serializable {
    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "benefit_id")
    private UUID benefitId;

}
