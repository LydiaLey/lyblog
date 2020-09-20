package com.ly.shiro;

import org.apache.shiro.authc.AuthenticationToken;
/**
 *
 * @author Lydia
 * @date 2020/9/17
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
