package cbd.com.vn.services;

import cbd.com.vn.model.Course;
import cbd.com.vn.model.Fee;
import cbd.com.vn.repository.CourseRepository;
import cbd.com.vn.repository.FeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    FeeRepository feeRepository;

    public String createCourse(JsonNode data) {

        if(data==null) try {
            throw new IllegalAccessException("Course Cannot Be NULL!!!");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        Course course = objectMapper.convertValue(data,Course.class);

        JsonNode node = data.get("fees");
        Course savedCourse = courseRepository.save(course);
        TypeReference<Set<Fee>> feesType = new TypeReference<Set<Fee>>() {};
        Set<Fee> fees = objectMapper.convertValue(node,feesType).stream().peek(fee -> fee.setCourse(course)).collect(Collectors.toSet());

        for(Fee fee : fees){
            fee.setCourse(savedCourse);
        }

        feeRepository.saveAll(fees);

        return null;
    }



}
