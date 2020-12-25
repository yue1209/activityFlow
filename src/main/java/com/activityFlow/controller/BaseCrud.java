package com.activityFlow.controller;

import com.activityFlow.Exception.MyException;
import com.activityFlow.vo.ResponsePageListVo;
import com.activityFlow.vo.ResponseResultVo;
import org.springframework.web.bind.annotation.*;


public interface BaseCrud<BaseDto, SearchDto, ResponseVo> {
    @GetMapping
    ResponsePageListVo<ResponseVo> selectList(SearchDto searchDto) throws MyException;

    @GetMapping("/{id}")
    ResponseResultVo<ResponseVo> selectOne(String id) throws MyException;

    @PostMapping
    ResponseResultVo<ResponseVo> insert(BaseDto insertDto) throws MyException;

    @PutMapping
    ResponseResultVo<ResponseVo> update(BaseDto updateDto) throws MyException;

    @DeleteMapping("/{id}")
    ResponseResultVo<ResponseVo> delete(String id) throws MyException;
}