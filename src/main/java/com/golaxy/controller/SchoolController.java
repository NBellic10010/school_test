package com.golaxy.controller;

import com.golaxy.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping("/school/identities")
    public List<Object> getFakeIdentitiesByUserId(@RequestParam("user_id") int userid) {
        return schoolService.getFakeIdentitiesByUserId(userid);
    }
}
