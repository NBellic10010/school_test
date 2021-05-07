package com.golaxy.service;

import com.golaxy.entity.Teacher;
import com.golaxy.repository.ClassRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.golaxy.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;

    Gson gson = new Gson();

    public Object getTeacherById(int id) {
        return teacherRepository.getTeacherByUserid((long) id);
    }

    public List<Object> getTeachersBySchoolId(int schoolId) {
        //TODO：modify
        // required: nickname, realname, gender, age, level, class, phonenum, status
        List<Object> teachers = teacherRepository.getTeachersBySchoolId((long) schoolId);
        List<Object> result = new ArrayList<>();
        for(Object teacherObject: teachers) {
            Teacher teacher = (Teacher) teacherObject;
            JsonObject teacherJson = new JsonObject();
            teacherJson.addProperty("nickname", teacher.getNickname());
            teacherJson.addProperty("realname", teacher.getRealname());
            teacherJson.addProperty("gender", teacher.isGender());
            teacherJson.addProperty("age", teacher.getAge());
            teacherJson.addProperty("userlevel", teacher.getUserlevel());
            teacherJson.addProperty("contact_info", teacher.getContactInfo());
            teacherJson.addProperty("status", teacher.getUserstatus());

            Long userid = teacher.getUserid();
            List<Object> classes = classRepository.getClassesBySchoolIdAndTeacherId((long) schoolId, userid);
            teacherJson.addProperty("classes", classes.toString());
            result.add(teacherJson.toString());
        }
        return result;
    }

    public Object setTeacherStatus(int teacherId, int status) {
        try {
            teacherRepository.setTeacherStatus((long) teacherId, status);
            return "success";
        } catch (Exception e) {
            //TODO add customexception
            throw new RuntimeException();
        }
    }

    public List<Object> getMatchesByTeacherId(int teacherId) {
        return null;
    }

    public List<Object> getTeachersByClassId(int classId) {
        return teacherRepository.getTeachersByClassId((long) classId);
    }

    public Object setTeacher(int teacherId, Teacher newTeacher) {
        Teacher teacher = (Teacher) teacherRepository.getTeacherByUserid((long) teacherId);
        teacher.setAge(newTeacher.getAge());
        teacher.setGender(newTeacher.isGender());
        teacher.setNickname(newTeacher.getNickname());
        teacher.setApplyTime(newTeacher.getApplyTime());
        teacher.setContactInfo(newTeacher.getContactInfo());
        teacher.setEnterTime(newTeacher.getEnterTime());
        teacher.setQuitTime(newTeacher.getQuitTime());
        teacher.setUserlevel(newTeacher.getUserlevel());
        teacherRepository.saveAndFlush(teacher);
        return "success";
    }

    public Object getTeacherByUsername(String username) {
        return teacherRepository.getTeacherByUsername(username);
    }
}
