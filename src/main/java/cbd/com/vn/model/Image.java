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
public class Image {
    @Id
    private UUID id;
    private String url;
}
