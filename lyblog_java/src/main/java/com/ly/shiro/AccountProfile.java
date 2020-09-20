package com.ly.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * 账号的基本信息
 *
 * @author Lydia
 * @date 2020/9/17
 */

@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

}
