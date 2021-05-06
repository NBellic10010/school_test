package com.golaxy.controller;

import com.golaxy.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.golaxy.repository.TeacherRepository;
import com.golaxy.service.TeacherService;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @GetMapping("/teachers/info/{teacher_id}")
    public Object getTeacherById(@PathVariable("teacher_id") int id) {
        return teacherService.getTeacherById(id);
    }

    @ResponseBody
    @PostMapping("/school/teachers")
    public Object addTeacher(@RequestBody Teacher newTeacher) {
        return null;
    }

    @ResponseBody
    @GetMapping("/school/teachers/{school_id}")
    public Object getTeachersBySchoolId(@PathVariable("school_id") int schoolId) {
        return teacherService.getTeachersBySchoolId(schoolId);
    }

    @ResponseBody
    @PutMapping("/school/teachers/status/{status}")
    public Object setTeacherStatus(@RequestParam("teacher_id") int teacherId,
            @PathVariable("status") int status) {
        return teacherService.setTeacherStatus(teacherId, status);
    }

    @ResponseBody
    @GetMapping("/school/teachers/matches")
    public List<Object> getMatchesByTeacherId(@RequestParam("teacher_id") int teacherId) {
        return null;
    }

    @ResponseBody
    @GetMapping("/school/teachers/{class_id}")
    public List<Object> getTeachersByClassId(@PathVariable("class_id") int classId) {
        return teacherService.getTeachersByClassId(classId);
    }

    @ResponseBody
    @PutMapping("/school/teachers")
    public Object setTeacherInfo(@RequestParam("teacher_id") int teacherId,
                                 @RequestBody Teacher newTeacher) {
        return teacherService.setTeacher(teacherId, newTeacher);
    }

    @ResponseBody
    @GetMapping("/school/teachers/{username}")
    public Object getTeacherByUsername(@PathVariable("username") String username) {
        return teacherService.getTeacherByUsername(username);
    }
}
