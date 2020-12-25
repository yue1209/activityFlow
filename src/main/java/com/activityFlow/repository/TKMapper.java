package com.activityFlow.repository;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用Mapper-使用基本CRUD和Mysql相关的操作
 *
 * @author yuyu
 * @date 2017-12-19
 */

public interface TKMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
