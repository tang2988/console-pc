package com.tang2988.gold.console.module.sys.entity.page;

import java.io.Serializable;

import com.tang2988.gold.console.common.entity.Page;

 /**
  * 功能：用户信息分页类
  *
  * @version 2016年12月26日下午5:46:40
  * @author baocheng.ren
  */
public class SysUserPage extends Page implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * 登录名搜索
     */
    private String loginName;
    
    /**
     * 真实姓名搜索
     */
    private String realName;
    
    public String getLoginName() {
        return loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }
    
}
