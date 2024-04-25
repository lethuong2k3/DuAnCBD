package cbd.com.vn.services;

import cbd.com.vn.model.Course;
import com.fasterxml.jackson.databind.JsonNode;

public interface CourseService {

    public String createCourse(JsonNode data);

}
