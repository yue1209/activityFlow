package com.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2019/9/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloActivity {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RepositoryService repositoryService;

    ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();


    // 将设计的流程图部署到数据库中
    @Test
    public void testDeploy() {
        // 创建部署构建器对象，用于加载流程定义文件(UserInfoAudit.bpmn,UserInfoAudit.myProcess.png)，部署流程定义
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.addClasspathResource("templates/processes/leaveBill.png");
        Deployment deployment = deploymentBuilder.deploy();
        System.out.println(deployment.getId());
    }

    // 查询流程定义
    @Test
    public void testQueryProcessDefinition() {
        // 流程定义查询对象，用于查询流程定义表----act_re_procdef
        ProcessDefinitionQuery query = pe.getRepositoryService().createProcessDefinitionQuery();
        // 添加过滤条件,取最新版本
        query.latestVersion();
        // query.processDefinitionId(processDefinitionId)
        // query.processDefinitionKey(processDefinitionKey);
        // 添加排序条件
        query.orderByProcessDefinitionVersion().desc();

        // 添加分页条件
        // query.listPage(firstResult, maxResults);

        // 查询所有流程
        List<ProcessDefinition> processDefinitionList = query.list();
        for (ProcessDefinition pd : processDefinitionList) {
            System.out.println(pd.getId());
        }

    }

    // 根据流程定义启动流程实例----操作的数据表：act_ru_execution act_ru_task
    @Test
    public void testStartProcess() {
        String processDefinitionId = "0920:2:504";
        //根据流程实例ID去启动流程
        ProcessInstance pInstance = pe.getRuntimeService().startProcessInstanceById(processDefinitionId);
        System.out.println(pInstance.getId());
    }

    //查询任务列表
    @Test
    public void testQueryTaskList() {
        //创建任务查询对象，查询表act_ru_task
        TaskQuery query = pe.getTaskService().createTaskQuery();
        String assignee = "张三";
        //添加过滤条件
        query.taskAssignee(assignee);
        //排序
        query.orderByTaskCreateTime().desc();
        List<Task> taskList = query.list();
        for (Task task : taskList) {
            System.out.println("taskId:" + task.getId() + ",taskName:" + task.getName());
        }
    }

    //办理任务
    //办理个人任务，操作的表是act_ru_execution,act_ru_task
    @Test
    public void testExecuteTask() {
        String taskId = "604";
        pe.getTaskService().complete(taskId);
    }
}
