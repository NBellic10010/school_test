package service;

import entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    public Object getTeacherById(int id) {
        return teacherRepository.getTeacherByUserid((long) id);
    }

    public Object getTeachersBySchoolId(int schoolId) {
        return teacherRepository.getTeachersBySchoolId((long) schoolId);
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

    public Object setTeacherState(int teacherId, int state) {
        try {
            teacherRepository.setTeacherState((long) teacherId, state);
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

    public Object setTeacherInfo(int teacherId, Teacher newTeacher) {
        //TODO setTeacherInfo()
        return null;
    }
}
