package com.activityFlow.dto;

import com.activityFlow.entity.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description
 */
@Data
public class UserDto extends BaseEntity {
    @Id
    private Long id;
    @NotBlank(message = "昵称不能为空")
    private String name;
    private Integer sex;
    @Range(min = 20, max = 120, message = "年龄范围20-120")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    private Integer hight;
}
