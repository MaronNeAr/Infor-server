package com.example.yin.dao;

import com.example.yin.domain.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {

    Course getCourseById(@Param("id") Integer id);

    int addCourse(Course course);

    int updateCourse(Course course);

    int deleteCourseById(Integer id);

    List<Course> selectAllCourse();

}
