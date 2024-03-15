package cbd.com.vn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Fee {
    @Id
    private UUID id;
    private Integer price;
    private UUID courseId;

}
