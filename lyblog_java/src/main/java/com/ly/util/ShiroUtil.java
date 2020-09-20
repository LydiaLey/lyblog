package com.ly.util;

import com.ly.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;
/**
 *
 * @author Lydia
 * @date 2020/9/17
 */
public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
