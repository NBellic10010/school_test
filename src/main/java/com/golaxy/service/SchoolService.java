package com.golaxy.service;

import com.golaxy.entity.School;
import com.golaxy.repository.SchoolRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public Object getSchoolById(int id) throws Exception {
        return schoolRepository.getById((long) id);
    }

    public Object getSchoolByAddress(String address) throws Exception {
        return schoolRepository.getByAddress(address);
    }

    public Object addSchool(School newSchool) throws Exception {
        //TODO: addSchool()
        return null;
    }

    public List<Object> getFakeIdentitiesByUserId(int userid) throws ParseException {
        List<Object> resultList = new ArrayList<>();
        if(userid == 101) {
            resultList.add(new JSONParser("{\"school\":\"星阵围棋学校\",\"identity\":1}").parse());
            resultList.add(new JSONParser("""
                    {"school":"弈客围棋道场","identity":2}
                    """).parse());
            resultList.add(new JSONParser("""
                    {"school":"弈客围棋道场","identity":3}
                    """).parse());
        } else if(userid == 102) {
            resultList.add(new JSONParser("""
                    {"school":"弈客围棋道场","identity":1}
                    """).parse());
            resultList.add(new JSONParser("""
                    {"school":"星阵围棋学校","identity":2}
                    """).parse());
            resultList.add(new JSONParser("""
                    {"school":"星阵围棋学校","identity":3}
                    """).parse());
        }
        return resultList;
    }

    public List<Object> getIdentitiesByUserId(int userid) {
        //TODO: getIdentitiesByUserId()
        return null;
    }
}
