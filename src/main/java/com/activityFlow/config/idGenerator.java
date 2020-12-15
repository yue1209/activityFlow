package com.activityFlow.config;


import org.activiti.engine.impl.cfg.IdGenerator;

import java.util.UUID;

public class idGenerator implements IdGenerator {

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * Activiti ID 生成
     */
    @Override
    public String getNextId() {
        return this.uuid();
    }
}