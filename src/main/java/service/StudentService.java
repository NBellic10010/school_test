package service;

import entity.Myclass;
import entity.School;
import entity.Student;
import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repository.ClassRepository;
import repository.StudentRepository;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;

    public List<Object> getAllStudentsBySchoolId(int schoolId) throws Exception {
        return studentRepository.getStudentsBySchoolId((long) schoolId);
    }

    public Object getStudentById(int studentId) {
        return studentRepository.getStudentByUserid((long) studentId);
    }

    @Transactional
    public Object addStudent(Student newStudent) {
       try {
           //TODO：ADD RELATIONS
           studentRepository.saveAndFlush(newStudent);
           return "Success";
       } catch (Exception e) {
           //TODO: create custom exceptions
            throw new RuntimeException();
       }
    }

    @Transactional
    public Object setStudent(Student newStudent, int studentId) {
        Student student = (Student) studentRepository.getStudentByUserid((long) studentId);
        student.setAge(newStudent.getAge());
        student.setGender(newStudent.isGender());
        student.setNickname(newStudent.getNickname());
        student.setApplyTime(newStudent.getApplyTime());
        student.setContactInfo(newStudent.getContactInfo());
        student.setEnterTime(newStudent.getEnterTime());
        student.setState(newStudent.getState());
        student.setQuitTime(newStudent.getQuitTime());
        student.setUserlevel(newStudent.getUserlevel());
        student.setRemarks(newStudent.getRemarks());
        studentRepository.saveAndFlush(student);
        return "success";
        //TODO
    }

    public List<Object> getMatchesByStudentId(int studentId) {
        return null;
    }

    public Object getDatesByStudentId(int studentId) {
        return studentRepository.getDatesByStudentId((long) studentId);
    }

    public Object setStateByStudentId(int studentId, int state) {
        try {
            studentRepository.setStateByStudentId((long) studentId, state);
            return "success";
        } catch (Exception e) {
            //TODO: create custom exceptions
            throw new RuntimeException();
        }
    }

    public Object setClassByStudentId(int studentId, int classId) {
        try {
            studentRepository.setClassByStudentId((long) classId, (long) studentId);
            return "success";
        } catch (Exception e) {
            //TODO: create custom exceptions
            throw new RuntimeException();
        }
    }

    public Object setStatusByStudentId(int studentId, int status) throws Exception {
        try {
            studentRepository.setStatusByStudentId((long) studentId, status);
            return "success";
        } catch (Exception e) {
            //TODO: create custom exceptions
            throw new RuntimeException();
        }
    }

    public List<Object> getStudentsByClassId(int classId) throws Exception {
        return studentRepository.getStudentsByClassId(classId);
    }

    public List<Object> getStudentsByTeacherId(int teacherId) throws Exception {
        return studentRepository.getStudentsByTeacherId(teacherId);
    }

    public List<Object> getStudentsByTeacherIdAndSchoolId(int teacherId, int schoolId) {
        return studentRepository.getStudentsByTeacherIdAndSchoolId(schoolId, teacherId);
    }

}
