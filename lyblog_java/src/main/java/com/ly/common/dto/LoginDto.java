package com.ly.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 将请求参数封装成对象
 *
 * @author Lydia
 * @date 2020/9/17
 */
@ApiModel(description="账户Dto")
@Data
public class LoginDto implements Serializable {
    @ApiModelProperty(value="用户名",name="username")
    @NotBlank(message = "昵称不能为空")
    private String username;

    @ApiModelProperty(value="密码",name="password")
    @NotBlank(message = "密码不能为空")
    private String password;
}
