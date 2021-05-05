package controller;

import entity.Myclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ClassService;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    @ResponseBody
    @GetMapping("/school/class")
    public List<Object> getClassesBySchoolId(@RequestParam("school_id") int schoolId) {
        return classService.getClassesBySchoolId(schoolId);
    }

    @ResponseBody
    @PostMapping("/school/class")
    public Object addClass(@RequestBody Myclass newClass,
                           @RequestParam List<String> students) {
        return classService.addClass(newClass, students);
    }

    @ResponseBody
    @GetMapping("/school/class/info")
    public Object getClassById(@RequestParam("class_id") int classId) {
        return classService.getClassById(classId);
    }
}
