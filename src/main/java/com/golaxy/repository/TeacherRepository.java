package com.golaxy.repository;

import com.golaxy.entity.Student;
import com.golaxy.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "select * from teacher t left join teacher_class_rel r on t.userid=r.teacher_id where school_id=?1", nativeQuery = true)
    List<Object> getTeachersBySchoolId(Long schoolId);

    Object getTeacherByUserid(Long userid);

    @Modifying
    @Query(value = "update teacher set status=?2 where userid=?1", nativeQuery = true)
    void setTeacherStatus(Long userid, int status);

    @Modifying
    @Query(value = "update teacher set state=?2 where userid=?1", nativeQuery = true)
    void setTeacherState(Long userid, int state);

    @Query(value = "select * from teacher t left join teacher_class_rel r where t.userid=r.teacher_id", nativeQuery = true)
    List<Object> getTeachersByClassId(Long classId);

    Object getTeacherByUsername(String username);
}
