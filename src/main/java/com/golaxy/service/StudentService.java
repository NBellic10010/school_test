package com.golaxy.service;

import com.golaxy.entity.Myclass;
import com.golaxy.entity.School;
import com.golaxy.entity.Student;
import com.golaxy.entity.Teacher;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.golaxy.repository.ClassRepository;
import com.golaxy.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;

    public List<Object> getAllStudentsBySchoolId(int schoolId) throws Exception {
        //required: nickname, realname, gender, age, userlevel, class, contact_info, status
        List<Object> studentsList = studentRepository.getStudentsBySchoolId((long) schoolId);
        List<Object> result = new ArrayList<>();
        for(Object studentObject: studentsList) {
            Student student = (Student) studentObject;
            JsonObject studentJson = new JsonObject();
            studentJson.addProperty("nickname", student.getNickname());
            studentJson.addProperty("realname", student.getRealname());
            studentJson.addProperty("gender", student.isGender());
            studentJson.addProperty("age", student.getAge());
            studentJson.addProperty("userlevel", student.getUserlevel());
            studentJson.addProperty("contact_info", student.getContactInfo());
            studentJson.addProperty("status", student.getUserstatus());

            List<Object> classes = classRepository.getClassesBySchoolIdAndStudentId((long) schoolId, student.getUserid());
            studentJson.addProperty("classes", classes.toString());
            result.add(studentJson);
        }
        return result;
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
