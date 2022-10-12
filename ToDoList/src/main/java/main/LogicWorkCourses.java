package main;

import main.model.Course;

import java.util.*;

public class LogicWorkCourses {
    private int currentId = 1;

    public HashMap<Integer, Course> courseMap = new HashMap<>();

    Map<Integer, String> getAllCoursesString() { //Этот метод дописал для тестов, чтобы он возвращал строку.
        Map<Integer, String> courses = new HashMap<>();
        for (Map.Entry<Integer, Course> entry : courseMap.entrySet()) {
            courses.put(entry.getKey(), entry.getValue().getNameCourses());
        }
        return courses;
    }

    Map<Integer, Course> getAllCourseMap() {
        Map<Integer, Course> courses = new HashMap<>();
        for (Map.Entry<Integer, Course> entry : courseMap.entrySet()) {
            courses.put(entry.getKey(), entry.getValue());
        }
        return courses;
    }

    String getCourse(int id) {
        return courseMap.get(id).getNameCourses();
    }

    int addCourses(String name) {
        int id = currentId++;
        Course courses = new Course(id, name);
        courseMap.put(id, courses);
        return id;
    }

    void updateCourses(int id, String name) {
        Course course = new Course(id, name);
        courseMap.replace(id, course);
    }

    void updateAllCourses(String name) {
        for (Map.Entry<Integer, Course> entry : courseMap.entrySet()) {
            Course course = new Course(entry.getKey(), name);
            courseMap.put(entry.getKey(), course);
        }
    }

    void deleteCourses(int id) {
        courseMap.remove(id);
    }

    void deleteAllCourses() {
        courseMap.clear();
    }
}