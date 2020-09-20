package com.ly.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Lydia
 * @date 2020/9/17
 */
@ApiModel(description = "用户对象user")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value="用户id",name="id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value="用户名",name="username")
    @NotBlank(message = "昵称不能为空")
    private String username;

    @ApiModelProperty(value="头像图片链接",name="avatar")
    private String avatar;

    @ApiModelProperty(value="用户email",name="email")
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @ApiModelProperty(value="用户密码",name="password")
    private String password;

    @ApiModelProperty(value="用户状态",name="status")
    private Integer status;

    @ApiModelProperty(value="账户创建时间",name="created")
    private LocalDateTime created;

    @ApiModelProperty(value="用户上次登录时间",name="lastLogin")
    private LocalDateTime lastLogin;


}
