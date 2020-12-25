package com.activityFlow.dto;

import com.activityFlow.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description
 */
@Data
public class BaseSearchDto {
    //页码
    private Integer pageNum;
    //每页条数
    private Integer pageSize;
}
