package com.activityFlow.activity;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RepositoryService repositoryService;

    /**
     * @param path
     * @return void
     * @Description 根据流程图片部署流程
     * @Date 2020/12/15
     */
    public void createProcess(String path) {
        //Deployment deploy = repositoryService.createDeployment().addClasspathResource("templates/processes/leaveBill.png").key("ces").category("测试").name("测试流程1").deploy();
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("templates/processes/001.bpmn").addClasspathResource("templates/processes/001.png").category("测试").name("测试流程1").deploy();
        System.out.println(deploy.toString());

        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        list.stream().forEach(a -> {
            System.out.println(a.toString());
        });

    }

    /**
     * @param key
     * @return void
     * @Description 启动流程实列
     * @Date 2020/12/15
     */
    public void startProcess(String key) {
        runtimeService.startProcessInstanceByKey(key);
        //runtimeService.startProcessInstanceById(key);
    }

    /**
     * @param assigine
     * @return void
     * @Description 任务列表
     * @Date 2020/12/15
     */
    public void taskList(String assigine) {
        List<Task> list = taskService.createTaskQuery().list();
        //List<Task> list = taskService.createTaskQuery().taskAssignee("").list();
        list.stream().forEach(task -> {
            System.out.println(task.toString());
        });
    }

    /**
     * @param taskId
     * @return void
     * @Description 完成任务
     * @Date 2020/12/15
     */
    public void complete(String taskId) {
        taskService.complete(taskId);
    }
}
