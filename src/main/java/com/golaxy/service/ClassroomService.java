package com.golaxy.service;

import com.golaxy.pojo.Classroom;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    //Cache<Classroom, Integer> classroomCache
    public Object getFakeClassroomByTeacherIdAndSchoolId() {
        return """
                [{name: "classroom1", 
                teacher: "teacher1",
                class: "class1, class2",
                start_time: "2021-04-29 00:00:00", 
                password: "111111",
                description: ""}, {name: "classroom2", 
                teacher: "teacher2",
                class: "class3, class4",
                start_time: "2021-04-30 00:00:00", 
                password: "123456",
                description: ""}]
                """;
    }
}
