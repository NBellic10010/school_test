package repository;

import entity.Myclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Myclass, Long> {
    @Query(value = "select * from class where school_id=?1", nativeQuery = true)
    List<Object> getClassesBySchoolId(int schoolId);

    @Query(value = "select * from class c left join teacher_class_rel r on r.class_id=c.id where c.school_id=?1 and r.teacher_id=?2", nativeQuery = true)
    List<Object> getClassesBySchoolIdAndTeacherId(int schoolId, int teacherId);

    @Query(value = "select * from class where id=?1", nativeQuery = true)
    Object getClassById(Long id);
}
