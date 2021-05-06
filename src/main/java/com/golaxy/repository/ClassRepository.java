package com.golaxy.repository;

import com.golaxy.entity.Myclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Myclass, Long> {
    @Query(value = "select * from class where school_id=?1", nativeQuery = true)
    List<Object> getClassesBySchoolId(Long schoolId);

    @Query(value = "select c.name from class c right join teacher_class_rel r on r.class_id=c.id where c.school_id=?1 and r.teacher_id=?2", nativeQuery = true)
    List<Object> getClassesBySchoolIdAndTeacherId(Long schoolId, Long teacherId);

    @Query(value = "select c.name from class c right join student_class_rel r on r.class_id=c.id where c.school_id=?1 and r.student_id=?2", nativeQuery = true)
    List<Object> getClassesBySchoolIdAndStudentId(Long schoolId, Long studentId);

    @Query(value = "select * from class where id=?1", nativeQuery = true)
    Object getClassById(Long id);
}
