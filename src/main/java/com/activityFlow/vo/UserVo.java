package com.activityFlow.vo;

import com.activityFlow.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yuyu <yu.yu@chinaott.net>
 * @date 2018-04-03
 */
@Data
public class UserVo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;
    private Integer hight;
}
