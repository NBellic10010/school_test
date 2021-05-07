package com.golaxy.repository;

import com.golaxy.entity.StudentApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentApplyRepository extends JpaRepository<StudentApply, Long> {
    @Query(value = "select * from student_apply where school_applied=?1", nativeQuery = true)
    List<Object> getStudentAppliesBySchoolId(Long schoolId);

    StudentApply getStudentApplyById(Long applyId);
}
