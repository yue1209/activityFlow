package com.activityFlow.controller;

import com.activityFlow.entity.User;
import com.activityFlow.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户相关")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "添加用户", notes = "添加用户", code = 200, produces = "application/json")
    @PostMapping("/user")
    public String addUser() {
        User user = new User();
        user.setAge(3);
        userRepository.save(user);
        return "ok";
    }

    @ApiOperation(value = "修改用户", notes = "添加用户", code = 200, produces = "application/json")
    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setAge(7);
        userRepository.save(user);
        return "ok";
    }
}
