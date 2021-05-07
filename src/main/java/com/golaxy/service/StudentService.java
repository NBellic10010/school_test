package com.golaxy.service;

import com.golaxy.entity.Student;
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

    public List<Object> getAllStudentsBySchoolId(int schoolId) {
        //required: nickname, realname, gender, age, userlevel, class, contact_info, status
        List<Student> studentsList = studentRepository.getStudentsBySchoolId((long) schoolId);
        List<Object> result = new ArrayList<>();
        for(Student student: studentsList) {
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
            result.add(studentJson.toString());
        }
        return result;
    }

    public Object getStudentById(int studentId) {
        return studentRepository.getStudentByUserid((long) studentId);
    }

    @Transactional
    public Object addStudent(Student newStudent) {
       //TODO： addStudent()
        return null;
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
        List<String> ret = studentRepository.getDatesByStudentId((long) studentId);
        String[] dates = ret.get(0).split(",");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("apply_time", dates[0]);
        jsonObject.addProperty("enter_time", dates[1]);
        jsonObject.addProperty("quit_time", dates[2]);
        return jsonObject.toString();
    }

    public Object setClassByStudentId(int studentId, int classId, int newClassId) {
        try {
            studentRepository.setClassByStudentId((long) classId, (long) studentId, (long) newClassId);
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
        return studentRepository.getStudentsByClassId((long)classId);
    }

    public List<Object> getStudentsByTeacherId(int teacherId) throws Exception {
        return studentRepository.getStudentsByTeacherId((long)teacherId);
    }

    public List<Object> getStudentsByTeacherIdAndSchoolId(int teacherId, int schoolId) {
        return studentRepository.getStudentsByTeacherIdAndSchoolId((long) schoolId, (long) teacherId);
    }

    public Object getStudentByUsername(String username) {
        return studentRepository.getStudentByUsername(username);
    }
}
