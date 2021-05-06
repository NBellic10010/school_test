package com.golaxy.utils;

import com.golaxy.entity.Student;
import com.golaxy.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public class SpecificationFactory implements JpaSpecificationExecutor<Student> {

    @Override
    public Optional<Student> findOne(Specification<Student> specification) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll(Specification<Student> specification) {
        return null;
    }

    @Override
    public Page<Student> findAll(Specification<Student> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<Student> findAll(Specification<Student> specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<Student> specification) {
        return 0;
    }


}
