package com.tang2988.gold.console.module.sys.entity.page;

import java.io.Serializable;

import com.tang2988.gold.console.common.entity.Page;

/**
 * 功能：角色类
 *
 * @version 2016年12月9日上午9:10:56
 * @author baocheng.ren
 */
public class RolePage extends Page implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * 角色名称
     */
    private String roleName;
    
    /**
     * 项目id
     */
    private String itemId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
