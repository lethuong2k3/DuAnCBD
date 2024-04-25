package cbd.com.vn.controller.admin;

import cbd.com.vn.model.Course;
import cbd.com.vn.services.CourseService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<?> createCourse(@RequestBody JsonNode data){

        return new ResponseEntity<>(courseService.createCourse(data), HttpStatus.CREATED);


    }

}
