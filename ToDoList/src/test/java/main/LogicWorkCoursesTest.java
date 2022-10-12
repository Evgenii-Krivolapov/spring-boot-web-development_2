package main;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

class LogicWorkCoursesTest {

    private LogicWorkCourses logicWorkCourses = new LogicWorkCourses();

    @Test
    void getAllCourseMapTest() {
        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "Java");
        expected.put(2, "PHP");
        expected.put(3, "Python");
        Assertions.assertEquals(expected,logicWorkCourses.getAllCoursesString());
    }

    @Test
    void getCourseTest() {
        String actual = logicWorkCourses.getCourse(1);
        String expected = "Java";
        Assertions.assertEquals(expected,actual);
    }

    @BeforeEach
    void addCoursesTest() {
        logicWorkCourses.addCourses("Java");
        logicWorkCourses.addCourses("PHP");
        logicWorkCourses.addCourses("Python");
    }

    @AfterEach
    void delCourseTest() {
        logicWorkCourses.deleteAllCourses();
    }

    @Test
    void updateCoursesTest() {
        logicWorkCourses.updateCourses(1, "JavaScript");

        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "JavaScript");
        expected.put(2, "PHP");
        expected.put(3, "Python");
        Assertions.assertEquals(expected,logicWorkCourses.getAllCoursesString());
    }

    @Test
    void updateAllCoursesTest() {
        logicWorkCourses.updateAllCourses("JavaScript");

        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "JavaScript");
        expected.put(2, "JavaScript");
        expected.put(3, "JavaScript");
        Assertions.assertEquals(expected,logicWorkCourses.getAllCoursesString());
    }

    @Test
    void deleteCoursesTest() {
        logicWorkCourses.deleteCourses(1);

        Map<Integer, String> expected = new HashMap<>();
        expected.put(2, "PHP");
        expected.put(3, "Python");
        Assertions.assertEquals(expected,logicWorkCourses.getAllCoursesString());
    }

    @Test
    void deleteAllCoursesTest() {
        logicWorkCourses.deleteAllCourses();
        Map<Integer, String> expected = new HashMap<>();
        Assertions.assertEquals(expected,logicWorkCourses.getAllCoursesString());
    }
}