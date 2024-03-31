package cbd.com.vn.services;

import cbd.com.vn.model.Image;
import cbd.com.vn.model.request.ImageRequest;
import cbd.com.vn.repository.ImageRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploadServiceImpl implements ImageUploadService{

    @Autowired
    Cloudinary cloudinary;

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image uploadImage(ImageRequest imageRequest) throws IOException, MaxUploadSizeExceededException {
        try {
            // Upload hình ảnh lên Cloudinary
            Map uploadResult = cloudinary.uploader().upload(imageRequest.getImage().getBytes(), ObjectUtils.asMap("public_id", "course-image"));

            // Lấy URL của hình ảnh đã được upload từ kết quả trả về
            String imageUrl = (String) uploadResult.get("url");

            // Trả về URL của hình ảnh đã được upload
            Image image = new Image();
            image.setUrl(imageUrl);

            return imageRepository.save(image);

        } catch (IOException ioException) {
            // Xử lý ngoại lệ IOException (nếu có)
            ioException.printStackTrace(); // In stack trace cho mục đích ghi nhật ký hoặc gỡ lỗi
            throw ioException; // Ném lại ngoại lệ IOException để báo lỗi lên lớp gọi
        } catch (MaxUploadSizeExceededException maxUploadSizeExceededException) {
            // Xử lý ngoại lệ khác (nếu có)
            maxUploadSizeExceededException.printStackTrace(); // In stack trace cho mục đích ghi nhật ký hoặc gỡ lỗi
            throw new RuntimeException("Error uploading image", maxUploadSizeExceededException); // Ném lại ngoại lệ RuntimeException để báo lỗi lên lớp gọi
        }
    }

    private void deleteImageByUrl(String url) {
        try {
            cloudinary.uploader().destroy(extractPublicId(url), ObjectUtils.emptyMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractPublicId(String cloudinaryUrl) {
        int startIndex = cloudinaryUrl.lastIndexOf('/') + 1;
        int endIndex = cloudinaryUrl.lastIndexOf('.');

        if (endIndex == -1 || startIndex >= endIndex) {
            return null;
        }

        return cloudinaryUrl.substring(startIndex, endIndex);
    }

    @Override
    public String deleteImageByID(Long id){
        try {
            Image image = imageRepository.findById(id).orElse(null);

            deleteImageByUrl(image.getUrl());

            imageRepository.deleteById(id);

            return "Xóa thành công!";
        }
        catch (Exception e){
            return "Xóa thất bại!";
        }
    }

    @Override
    public Page<Image> getAll(int page,int size , Sort sort){
        Pageable pageable = PageRequest.of(page, size,sort);

        return imageRepository.findAll(pageable);
    }


}
