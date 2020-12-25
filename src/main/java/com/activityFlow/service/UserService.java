package com.activityFlow.service;

import cn.hutool.core.bean.BeanUtil;
import com.activityFlow.contanst.ResponseConstants;
import com.activityFlow.dto.UserDto;
import com.activityFlow.dto.UserSearchDto;
import com.activityFlow.entity.User;
import com.activityFlow.repository.mapper.UserMapper;
import com.activityFlow.vo.ResponsePageListVo;
import com.activityFlow.vo.ResponseResultVo;
import com.activityFlow.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public ResponsePageListVo<UserVo> selectList(UserSearchDto userSearchDto) {
        return null;
    }


    public ResponseResultVo<UserVo> selectOne(String id) {
        User user = new User();
        user.setId(Long.valueOf(id));
        user.setDeleteFlag(0);

        User userDB = userMapper.selectByPrimaryKey(user);
        if (Objects.nonNull(userDB)) {
            UserVo userVo = new UserVo();
            BeanUtil.copyProperties(userDB, userVo);
            return new ResponseResultVo<>(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS_MSG, userVo);
        }
        return new ResponseResultVo<>(ResponseConstants.ERROR_CODE, ResponseConstants.ERROR_MSG);
    }


    public ResponseResultVo<UserVo> insert(UserDto insertDto) {
        User user = new User();
        BeanUtil.copyProperties(insertDto, user);

        userMapper.insertSelective(user);

        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(user, userVo);
        return new ResponseResultVo<>(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS_MSG, userVo);
    }


    public ResponseResultVo<UserVo> update(UserDto updateDto) {
        User user = new User();
        BeanUtil.copyProperties(updateDto, user);

        userMapper.updateByPrimaryKeySelective(user);

        UserVo userVo = new UserVo();
        BeanUtil.copyProperties(user, userVo);
        return new ResponseResultVo<>(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS_MSG);
    }


    public ResponseResultVo<UserVo> delete(String id) {
        User user = new User();
        user.setDeleteFlag(1);
        userMapper.updateByPrimaryKeySelective(user);
        return new ResponseResultVo<>(ResponseConstants.SUCCESS_CODE, ResponseConstants.SUCCESS_MSG);
    }
}
