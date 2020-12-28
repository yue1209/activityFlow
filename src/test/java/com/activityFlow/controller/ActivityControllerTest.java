package com.activityFlow.controller;

import com.activityFlow.activity.ActivityService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityControllerTest extends BaseControllerTest {
    private final Logger logger = LoggerFactory.getLogger(ActivityControllerTest.class);

    @Autowired
    private ActivityService activityService;

    @Test
    public void createProcess() throws Exception {
        activityService.createProcess("");
    }

    @Test
    public void startProcess() throws Exception {
        activityService.startProcess("myProcess_1");
    }

    @Test
    public void taskList() throws Exception {
        activityService.taskList("");
    }

    @Test
    public void complete() throws Exception {
        activityService.complete("68b87cd16ff445428dcca71b7f445e97");
    }

}