package com.golaxy.repository;

import com.golaxy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
            select
                *
            from\s
                student s
            right join
                (select
                    s_c_r.student_id s_id
                from\s
                    student_class_rel s_c_r
                left join\s
                    class c
                on
                    c.id = s_c_r.class_id
                where\s
                    c.school_id = ?1) sids
            on
                s.userid = sids.s_id
            """, nativeQuery = true)
    List<Object> getStudentsBySchoolId(Long schoolId);

    Object getStudentByUserid(Long UserId);

    @Query(value = "select * from student_class_rel where class_id=?1", nativeQuery = true)
    List<Object> getStudentByClassId(int classId);

    @Query(value = "select apply_time, enter_time, quit_time from student where userid=?1", nativeQuery = true)
    Object getDatesByStudentId(Long studentId);

    @Modifying
    @Query(value = "update student set state=?2 where userid=?1", nativeQuery = true)
    void setStateByStudentId(Long studentId, int state);

    @Modifying
    @Query(value = "update student_class_rel set class_id=?1 where student_id=?2", nativeQuery = true)
    void setClassByStudentId(Long classid, Long studentId);

    @Modifying
    @Query(value = "update students set status=?1 where userid=?2", nativeQuery = true)
    void setStatusByStudentId(Long studentId, int status);

    @Query(value = "select * from student s left join student_class_rel r on r.student_id=s.userid where r.class_id=?1", nativeQuery = true)
    List<Object> getStudentsByClassId(int classId);

    @Query(value = "select * from student s left join student_teacher_rel r on r.student_id=s.userid where r.teacher_id=?1", nativeQuery = true)
    List<Object> getStudentsByTeacherId(int teacherId);

    @Query(value = """
            select
                *
            from\s
                student
            right join
                (select\s
                    * \s
                from
                    student_class_rel s_c_r
                inner join   \s
                    (select
                        c.id c_id
                    from\s
                        class c
                    right join\s
                        teacher_class_rel t_c_r
                    on\s
                        c.id = t_c_r.class_id
                    where\s
                        c.school_id = ?1
                        and t_c_r.teacher_id = ?2) classes
                on
                    classes.c_id = s_c_r.class_id) c_s_r
            on
                student.userid = c_s_r.student_id
            """, nativeQuery = true)
    List<Object> getStudentsByTeacherIdAndSchoolId(int schoolId, int teacherID);
}
