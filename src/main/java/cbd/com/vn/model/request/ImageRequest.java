package cbd.com.vn.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ImageRequest {

    @NotEmpty(message = "Images must not be empty")
    private MultipartFile image;

}
