package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping("/school/students")
    public Object getAllStudentsBySchoolId(@RequestParam("school_id") int schoolId) throws Exception {
        return studentService.getAllStudentsBySchoolId(schoolId);
    }

    @ResponseBody
    @GetMapping("/students/info")
    public Object getStudentById(@RequestParam("student_id") int studentId) throws Exception {
        return studentService.getStudentById(studentId);
    }

    @ResponseBody
    @PostMapping("/school/students")
    public Object addStudent(@RequestBody Student newStudent) throws Exception {
        return studentService.addStudent(newStudent);
    }

    @ResponseBody
    @GetMapping("/school/students/matches")
    public List<Object> getMatchesByStudentId(@RequestParam("student_id") int studentId) throws Exception {
        return studentService.getMatchesByStudentId(studentId);
    }

    @ResponseBody
    @GetMapping("/school/students/dates")
    public Object getDatesByStudentId(@RequestParam("student_id") int studentId ) throws Exception {
        return studentService.getDatesByStudentId(studentId);
    }

    @ResponseBody
    @PutMapping("/school/students/{state}")
    public Object setStateByStudentId(@RequestParam("student_id") int studentId,
                                      @PathVariable("state") int state) throws Exception {
        return studentService.setStateByStudentId(studentId, state);
    }

    //TODO: CAN BE DISCARDED
    @ResponseBody
    @PutMapping("/school/students/class")
    public Object setClassByStudentId(@RequestParam("student_id") int studentId,
                                      @RequestParam("class_id") int classId) throws Exception {
        return studentService.setClassByStudentId(studentId, classId);
    }

    @ResponseBody
    @PutMapping("/school/students/status")
    public Object setStatusByStudentId(@RequestParam("student_id") int studentId,
                                       @RequestParam("status") int status) throws Exception {
        return studentService.setStatusByStudentId(studentId, status);
    }

    @ResponseBody
    @PutMapping("/school/students")
    public Object setStudentInfo(@RequestParam("student_id") int studentId,
                             @RequestBody Student newStudent) throws Exception {
        return studentService.setStudent(newStudent, studentId);
    }

    @ResponseBody
    @GetMapping("/school/class/students")
    public List<Object> getStudentsByClassId(@RequestParam("class_id") int classId) throws Exception {
        return studentService.getStudentsByClassId(classId);
    }

    @ResponseBody
    @GetMapping("/school/students/{teacher_id}")
    public List<Object> getStudentsByTeacherIdAndSchoolId(@PathVariable("teacher_id") int teacherId,
                                                          @RequestParam("school_id") int schoolId) throws Exception {
        return studentService.getStudentsByTeacherIdAndSchoolId(teacherId, schoolId);
    }

}
