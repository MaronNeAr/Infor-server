package com.example.yin.service;

import com.example.yin.dao.CourseMapper;
import com.example.yin.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseMapper courseMapper;

    public Course getCourseById(Integer id) {
        return courseMapper.getCourseById(id);
    }

    public boolean addCourse(Course course) {
        return courseMapper.addCourse(course) > 0;
    }

    public boolean updateCourse(Course course) {
        return courseMapper.updateCourse(course) > 0;
    }

    public boolean deleteCourseById(Integer id) {
        return courseMapper.deleteCourseById(id) > 0;
    }

    public List<Course> selectAllCourse() {
        return courseMapper.selectAllCourse();
    }

}
