package com.golaxy.controller;

import com.golaxy.entity.Myclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.golaxy.service.ClassService;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    @ResponseBody
    @GetMapping("/school/class/{school_id}")
    public List<Object> getClassesBySchoolId(@PathVariable("school_id") int schoolId) {
        return classService.getClassesBySchoolId(schoolId);
    }

    @ResponseBody
    @PostMapping("/school/class")
    public Object addClass(@RequestBody Myclass newClass,
                           @RequestParam List<String> students) {
        return classService.addClass(newClass, students);
    }

    @ResponseBody
    @GetMapping("/school/class/info/{class_id}")
    public Object getClassById(@PathVariable("class_id") int classId) {
        return classService.getClassById(classId);
    }

    @ResponseBody
    @GetMapping("/school/class")
    public Object getClassBySchoolIdAndTeacherId(@RequestParam("school_id") int schoolId,
                                                 @RequestParam("teacher_id") int teacherId) {
        return classService.getClassesBySchoolIdAndTeacherId(schoolId, teacherId);
    }
}
