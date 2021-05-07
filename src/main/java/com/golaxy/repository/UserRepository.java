package com.golaxy.repository;

import com.golaxy.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    Object getUserInfoByUsername(String username);
}
