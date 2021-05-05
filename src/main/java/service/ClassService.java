package service;

import entity.Myclass;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClassRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    public List<Object> getClassesBySchoolId(int schoolId) {
        return classRepository.getClassesBySchoolId(schoolId);
    }

    @Transactional
    public Object addClass(Myclass newClass, List<String> students) {
        //TODO: add all students
        try{
            classRepository.saveAndFlush(newClass);
            return "success";
        } catch (Exception e) {
            //TODO: create custom exceptions
            throw new RuntimeException();
        }
    }

    public Object getClassById(int classId) {
        return classRepository.getClassById((long) classId);
    }
}
