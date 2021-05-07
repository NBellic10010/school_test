package com.golaxy.service;

import com.golaxy.entity.UserInfo;
import com.golaxy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Object getUserinfoByUsername(String username) {
        return userRepository.getUserInfoByUsername(username);
    }
}
