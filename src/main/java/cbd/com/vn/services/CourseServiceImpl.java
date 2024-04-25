package cbd.com.vn.services;

import cbd.com.vn.model.Course;
import cbd.com.vn.repository.CourseRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;


    public String createCourse(JsonNode data) {

        if(data==null) try {
            throw new IllegalAccessException("Course Cannot Be NULL!!!");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        Course course = objectMapper.convertValue(data,Course.class);
        System.out.println(course);
        return null;
    }

}
