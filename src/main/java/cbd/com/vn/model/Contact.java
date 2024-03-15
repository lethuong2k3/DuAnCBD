package cbd.com.vn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Contact {
    @Id
    private UUID id;
    private String name;
    private Integer age;
    private String contactName;
    private String phone;
    private String address;
    private UUID courseId;
    private String schedule;
    private String message;
}
