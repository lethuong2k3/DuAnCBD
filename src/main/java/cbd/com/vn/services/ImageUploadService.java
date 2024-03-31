package cbd.com.vn.services;

import cbd.com.vn.model.Image;
import cbd.com.vn.model.request.ImageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;


public interface ImageUploadService {

    Image uploadImage(ImageRequest imageRequest) throws IOException, MaxUploadSizeExceededException;
    String deleteImageByID(Long id);
    public Page<Image> getAll(int page,int size , Sort sort);
}
