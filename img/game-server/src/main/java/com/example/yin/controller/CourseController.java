package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.domain.Course;
import com.example.yin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/course")
    public Object getAllCourse() {
        return new SuccessMessage<List<Course>>(null, courseService.selectAllCourse()).getMessage();
    }

    @GetMapping("/course/delete/{id}")
    public Object deleteCourse(@PathVariable("id") Integer id) {
        boolean flag = courseService.deleteCourseById(id);
        if (!flag) return new ErrorMessage("删除课程失败").getMessage();
        else return new SuccessMessage<Boolean>("删除课程成功", true).getMessage();
    }

    @PostMapping("/course/add")
    public Object addCourse(HttpServletRequest req) {
        Course course = new Course();
        course.setName(req.getParameter("name"));
        course.setCode(req.getParameter("code"));
        course.setCredit(Double.valueOf(req.getParameter("credit")));
        return new SuccessMessage<Boolean>("添加成功！",courseService.addCourse(course)).getMessage();
    }
}
