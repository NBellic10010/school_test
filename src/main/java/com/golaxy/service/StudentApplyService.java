package com.golaxy.service;

import com.golaxy.entity.StudentApply;
import com.golaxy.entity.UserInfo;
import com.golaxy.exception.CustomException;
import com.golaxy.repository.StudentApplyRepository;
import com.golaxy.repository.UserRepository;
import com.golaxy.utils.ErrorCode;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentApplyService {

    @Autowired
    private StudentApplyRepository studentApplyRepository;

    @Autowired
    private UserRepository userRepository;

    public Object addStudentApply(String realname, String userlevel, int appliedSchool,
                                  int age, boolean gender, String username) {
        try {
            StudentApply studentApply = StudentApply.builder()
                    .realname(realname)
                    .userlevel(userlevel)
                    .schoolApplied(appliedSchool)
                    .gender(gender)
                    .age(age)
                    .username(username)
                    .build();
            studentApplyRepository.saveAndFlush(studentApply);
        } catch (Exception e) {
            throw new RuntimeException();
            //TODO: add customexception for addStudentApply()
        }
        return "success";
    }


    public List<Object> getStudentAppliesBySchoolId(int schoolId) {
        List<Object> studentApplies = studentApplyRepository.getStudentAppliesBySchoolId((long) schoolId);
        List<Object> result = new ArrayList<>();

        for(Object studentApplyObject: studentApplies) {
            StudentApply studentApply = (StudentApply) studentApplyObject;
            String username = studentApply.getUsername();
            UserInfo user = (UserInfo) userRepository.getUserInfoByUsername(username);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("nickname", user.getNickname());
            jsonObject.addProperty("realname", studentApply.getRealname());
            jsonObject.addProperty("gender", studentApply.isGender());
            jsonObject.addProperty("age", studentApply.getAge());
            jsonObject.addProperty("userlevel", studentApply.getUserlevel());
            jsonObject.addProperty("phone_num", studentApply.getUsername());

            result.add(jsonObject.toString());
         }
        return result;
    }

    public Object checkforStudentApply(int applyId, int state, String msg) {
        try{
            StudentApply studentApply = studentApplyRepository.getStudentApplyById((long) applyId);
            if(state == 1 && !msg.equals("")) throw new CustomException(ErrorCode.E01);
            studentApply.setState(state);
            studentApply.setMsg(msg);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException();
            //TODO: add customexception fro checkforStudentApply()
        }
    }

    public Object setStudentSchoolApplied(String username) {
        return null;
        //TODO:finish setStudentSchoolApplied()
    }
}
