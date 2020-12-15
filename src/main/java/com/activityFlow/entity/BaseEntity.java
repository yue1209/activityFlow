package com.activityFlow.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础操作实例
 *
 * @author yuyu <yu.yu@chinaott.net>
 * @date 2017-12-20
 */
@Data
public class BaseEntity implements Serializable {
    @ApiModelProperty(value = "删除标记 0 有效 1 无效")
    private Integer deleteFlag;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "创建人")
    private String createBy;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    @ApiModelProperty(value = "修改人")
    private String updateBy;
}
