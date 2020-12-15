package com.activityFlow.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "基础类")
public class BaseController {

    @ApiOperation(value = "首页", notes = "首页访问", code = 200, produces = "application/json")
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
