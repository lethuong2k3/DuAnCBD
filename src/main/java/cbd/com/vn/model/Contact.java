package cbd.com.vn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String contactName;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private String schedule;
    private String message;
    private Integer status;
}
