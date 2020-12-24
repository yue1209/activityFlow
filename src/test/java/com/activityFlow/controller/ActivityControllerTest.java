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
        activityService.startProcess("11");
    }

    @Test
    public void taskList() throws Exception {

    }

    @Test
    public void complete() throws Exception {

    }

}