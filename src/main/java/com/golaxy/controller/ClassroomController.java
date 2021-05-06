package com.golaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.golaxy.service.ClassroomService;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("classroom/{teacher_id}")
    public Object getClassroomByTeacherIdAndSchoolId(@PathVariable("teacher_id") String teacherId) {
        return classroomService.getFakeClassroomByTeacherIdAndSchoolId();
    }
}
