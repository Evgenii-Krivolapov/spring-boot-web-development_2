package main;

import main.model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    private LogicWorkCourses logicWorkCourses = new LogicWorkCourses();

    //Method returns all courses
    @GetMapping("/courses/")
    public ResponseEntity<?> getAllCourses() {
        if (logicWorkCourses.courseMap.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag("Courses not found").body(null);
        }
        return new ResponseEntity<>(logicWorkCourses.getAllCourseMap(), HttpStatus.OK);
    }

    //Method returns course by id
    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourses(@PathVariable int id) {
        if (!logicWorkCourses.courseMap.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag("id not found").body(null);
        }
        return new ResponseEntity<>(logicWorkCourses.getCourse(id), HttpStatus.OK);
    }

    //Method adds courses
    @PostMapping("/courses/")
    public ResponseEntity<?> addCourse(String name) {
        return new ResponseEntity<>(logicWorkCourses.addCourses(name), HttpStatus.CREATED);
    }

    //Method update course by id
    @PutMapping("/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, String name) {
        if (logicWorkCourses.courseMap.containsKey(id)) {
            logicWorkCourses.updateCourses(id, name);
            return new ResponseEntity<>("exchange course made: " + name, HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).eTag("id not found").body(null);
    }

    //Method update all courses
    @PutMapping("/courses/")
    public ResponseEntity<?> updateAllCourses(String name) {
        logicWorkCourses.updateAllCourses(name);
        return new ResponseEntity<>("exchange course made: " + name, HttpStatus.CREATED);
    }

    //Method delete by id
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        if (logicWorkCourses.courseMap.containsKey(id)) {
            logicWorkCourses.deleteCourses(id);
            return new ResponseEntity<>("course has been deleted, №" + id, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    //Method for delete all courses
    @DeleteMapping("/courses/")
    public ResponseEntity<?> deleteAllCourses() {
        if (!logicWorkCourses.courseMap.isEmpty()) {
            logicWorkCourses.deleteAllCourses();
            return new ResponseEntity<>("all courses has been deleted", HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
