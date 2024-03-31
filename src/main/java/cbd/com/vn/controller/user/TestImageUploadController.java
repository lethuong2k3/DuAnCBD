package cbd.com.vn.controller.user;

import cbd.com.vn.model.Image;
import cbd.com.vn.model.request.ImageRequest;
import cbd.com.vn.services.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/image")
public class TestImageUploadController {

    @Autowired
    ImageUploadService imageUploadService;



    @PostMapping
    public ResponseEntity<Image> pushImage(@RequestParam("image") MultipartFile file ) throws IOException {

        ImageRequest imageRequest= new ImageRequest();

        imageRequest.setImage(file);

        Image upload = imageUploadService.uploadImage(imageRequest);

        return new ResponseEntity<>(upload,HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteImage(@RequestParam("id") Long id){

        return new ResponseEntity<>(imageUploadService.deleteImageByID(id),HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Page<Image>> getAll(@RequestParam(value = "page",defaultValue = "1") int page,
                                              @RequestParam(value = "limit",defaultValue = "10") int limit
    ){

        Sort sort = Sort.by("id").ascending();
        return new ResponseEntity<>(imageUploadService.getAll(page,limit,sort),HttpStatus.OK);

    }


}
