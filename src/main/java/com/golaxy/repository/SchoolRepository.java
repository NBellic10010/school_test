package com.golaxy.repository;

import com.golaxy.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SchoolRepository extends JpaRepository<School, Long> {
    Object getByAddress(String address);

    Object getById(Long id);

//    @Query(value = "", nativeQuery = true)
//    Object getByMaster(Long masterId);
//    //TODO: getByMaster
}
