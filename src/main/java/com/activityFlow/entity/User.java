package com.activityFlow.entity;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author yuyu <yu.yu@chinaott.net>
 * @date 2018-04-03
 */
@Data
public class User extends BaseEntity {
    @Id
    private Long id;
    private String name;
    private Integer sex;
    private Integer age;
    private Integer hight;
}
