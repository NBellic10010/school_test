package controller;

import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.TeacherRepository;
import service.TeacherService;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @GetMapping("/teachers/info")
    public Object getTeacherById(@RequestParam("teacher_id") int id) {
        //TODO: teacher controller
        return teacherService.getTeacherById(id);
    }

    @ResponseBody
    @PostMapping("/school/teachers")
    public Object addTeacher(@RequestBody Teacher newTeacher) {
        return null;
    }

    @ResponseBody
    @GetMapping("/school/teachers")
    public Object getTeachersBySchoolId(@RequestParam("school_id") int schoolId) {
        return teacherService.getTeachersBySchoolId(schoolId);
    }

    @ResponseBody
    @PutMapping("/school/teachers/status/{status}")
    public Object setTeacherStatus(@RequestParam("teacher_id") int teacherId,
            @PathVariable("status") int status) {
        return teacherService.setTeacherStatus(teacherId, status);
    }

    @ResponseBody
    @PutMapping("/school/teachers/state/{state}")
    public Object setTeacherState(@RequestParam("teacher_id") int teacherId,
                                  @PathVariable("state") int state) {
        return teacherService.setTeacherState(teacherId, state);
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
        return teacherService.setTeacherInfo(teacherId, newTeacher);
    }
}
