package com.activityFlow.controller;

import com.activityFlow.Exception.ErrorCode;
import com.activityFlow.Exception.MyException;
import com.activityFlow.dto.UserDto;
import com.activityFlow.dto.UserSearchDto;
import com.activityFlow.service.UserService;
import com.activityFlow.vo.ResponsePageListVo;
import com.activityFlow.vo.ResponseResultVo;
import com.activityFlow.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@Api(tags = "用户相关")
@RequestMapping("/user")
public class UserController implements BaseCrud<UserDto, UserSearchDto, UserVo> {

    @Autowired
    private UserService userService;

    @Override
    public ResponsePageListVo<UserVo> selectList(@Valid @RequestBody UserSearchDto userSearchDto) {
        return null;
    }

    @Override
    @ApiOperation(value = "查询用户", notes = "查询用户")
    public ResponseResultVo<UserVo> selectOne(@PathVariable String id) {
        return userService.selectOne(id);
    }

    @Override
    @ApiOperation(value = "添加用户", notes = "添加用户", produces = "application/json")
    public ResponseResultVo<UserVo> insert(@Valid @RequestBody UserDto insertDto) throws MyException {
        return userService.insert(insertDto);
    }

    @Override
    @ApiOperation(value = "修改用户", notes = "修改用户", produces = "application/json")
    public ResponseResultVo<UserVo> update(@Valid @RequestBody UserDto updateDto) {
        return userService.update(updateDto);
    }

    @Override
    @ApiOperation(value = "删除用户", notes = "删除用户", code = 200)
    public ResponseResultVo<UserVo> delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
