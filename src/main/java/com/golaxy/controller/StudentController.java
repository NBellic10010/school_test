package com.golaxy.controller;

import com.golaxy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.golaxy.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/school/students/{school_id}")
    public List<Object> getAllStudentsBySchoolId(@PathVariable("school_id") int schoolId) throws Exception {
        return studentService.getAllStudentsBySchoolId(schoolId);
    }

    @ResponseBody
    @GetMapping("/students/info/{student_id}")
    public Object getStudentById(@PathVariable("student_id") int studentId) throws Exception {
        return studentService.getStudentById(studentId);
    }

    @ResponseBody
    @GetMapping("/school/students")
    public List<Object> getStudentsByTeacherIdAndSchoolId(@RequestParam("teacher_id") int teacherId,
                                                          @RequestParam("school_id") int schoolId) throws Exception {
        return studentService.getStudentsByTeacherIdAndSchoolId(teacherId, schoolId);
    }

    @ResponseBody
    @PostMapping("/school/students")
    public Object addStudent(@RequestBody Student newStudent) throws Exception {
        return studentService.addStudent(newStudent);
    }

    @ResponseBody
    @PutMapping("/school/students")
    public Object setStudentInfo(@RequestParam("student_id") int studentId,
                                 @RequestBody Student newStudent) throws Exception {
        return studentService.setStudent(newStudent, studentId);
    }

    @ResponseBody
    @GetMapping("/school/students/matches/{student_id}")
    public List<Object> getMatchesByStudentId(@PathVariable("student_id") int studentId) throws Exception {
        return studentService.getMatchesByStudentId(studentId);
    }

    @ResponseBody
    @GetMapping("/school/students/dates/{student_id}")
    public Object getDatesByStudentId(@PathVariable("student_id") int studentId ) throws Exception {
        return studentService.getDatesByStudentId(studentId);
    }

    //TODO: CAN BE DISCARDED
    @ResponseBody
    @PutMapping("/school/students/class")
    public Object setClassByStudentId(@RequestParam("student_id") int studentId,
                                      @RequestParam("class_id") int classId) throws Exception {
        return studentService.setClassByStudentId(studentId, classId);
    }

    @ResponseBody
    @PutMapping("/school/students/status/{status}")
    public Object setStatusByStudentId(@RequestParam("student_id") int studentId,
                                       @PathVariable("status") int status) throws Exception {
        return studentService.setStatusByStudentId(studentId, status);
    }

    @ResponseBody
    @GetMapping("/school/class/students/{class_id}")
    public List<Object> getStudentsByClassId(@PathVariable("class_id") int classId) throws Exception {
        return studentService.getStudentsByClassId(classId);
    }
}
