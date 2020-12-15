package com.activityFlow.controller;

import com.activityFlow.activity.ActivityService;
import com.activityFlow.entity.User;
import com.activityFlow.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "activity相关")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @ApiOperation(value = "部署流程")
    @PostMapping("/createProcess")
    public String createProcess() {
        activityService.createProcess("");
        return "ok";
    }

    @ApiOperation(value = "启动流程")
    @PostMapping("/startProcess/{key}")
    public String startProcess(@PathVariable("key") String key) {
        activityService.startProcess(key);
        return "ok";
    }

    @ApiOperation(value = "任务列表")
    @PostMapping("/taskList")
    public String taskList() {
        activityService.taskList("");
        return "ok";
    }

    @ApiOperation(value = "完成任务")
    @PostMapping("/complete/{taskId}")
    public String complete(@PathVariable("taskId") String taskId) {
        activityService.complete(taskId);
        return "ok";
    }
}
