package com.golaxy.service;

import com.golaxy.repository.SchoolRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    public List<Object> getFakeIdentitiesByUserId(int userid) {
        List<Object> resultList = new ArrayList<>();
        if(userid == 101) {
            resultList.add("""
                    {"school":"星阵围棋学校","identity":1}
                    """);
            resultList.add("""
                    {"school":"弈客围棋道场","identity":2}
                    """);
            resultList.add("""
                    {"school":"弈客围棋道场","identity":3}
                    """);
        } else if(userid == 102) {
            resultList.add("""
                    {"school":"弈客围棋道场","identity":1}
                    """);
            resultList.add("""
                    {"school":"星阵围棋学校","identity":2}
                    """);
            resultList.add("""
                    {"school":"星阵围棋学校","identity":3}
                    """);
        }
        return resultList;
    }

    public List<Object> getIdentitiesByUserId(int userid) {
        //TODO: getIdentitiesByUserId()
        return null;
    }
}
