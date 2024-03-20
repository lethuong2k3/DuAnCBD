package cbd.com.vn.model;


import jakarta.persistence.*;

@Entity
public class CourseBenefit {
    @EmbeddedId
    private CourseBenefitId id;

}
