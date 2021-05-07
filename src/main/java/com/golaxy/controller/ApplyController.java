package com.golaxy.controller;

import com.golaxy.entity.StudentApply;
import com.golaxy.service.StudentApplyService;
import com.golaxy.service.TeacherApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplyController {

    @Autowired
    private StudentApplyService studentApplyService;

    @Autowired
    private TeacherApplyService teacherApplyService;

    @PostMapping("/school/apply/student")
    public Object addStudentApply(@RequestParam("realname") String realname,
                           @RequestParam("userlevel") String userlevel,
                           @RequestParam(value = "applied_school", required = false) int appliedSchool,
                          @RequestParam(value = "age", required = false) int age,
                           @RequestParam(value = "gender", required = false) boolean gender,
                           @RequestParam(value = "username") String username) {

        return studentApplyService.addStudentApply(realname, userlevel, appliedSchool, age, gender, username);
    }

    @GetMapping("/school/apply/student/{school_id}")
    public List<Object> getStudentAppliesBySchoolId(@PathVariable("school_id") int schoolId) {
        return studentApplyService.getStudentAppliesBySchoolId(schoolId);
    }

    @PutMapping("/school/apply/student/check")
    public Object checkforStudentApply(@RequestParam("apply_id") int applyId,
                                             @RequestParam("state") int state,
                                             @RequestParam("msg") String msg) {
        return studentApplyService.checkforStudentApply(applyId, state, msg);
    }

    @PutMapping("/school/apply/student")
    public Object SetStudentSchoolApplied(@RequestParam("username") String username) {
        return studentApplyService.setStudentSchoolApplied(username);
    }
}
