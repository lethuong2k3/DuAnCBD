package cbd.com.vn.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tiêu đề không được để trống")
    private String title;

    @NotNull(message = "Phải có giá tiền")
    @Positive(message = "Giá tiền phải lớn hơn 0")
    private Double price;

    @Size(max = 2000,message = "Mô tả không được quá 2000 ký tự")
    private String description;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private Integer status;
}
