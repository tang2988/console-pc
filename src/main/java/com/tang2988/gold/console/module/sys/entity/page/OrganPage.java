package com.tang2988.gold.console.module.sys.entity.page;

import java.io.Serializable;

import com.tang2988.gold.console.common.entity.Page;

/**
 * 功能：角色类
 *
 * @version 2016年12月9日上午9:10:56
 * @author baocheng.ren
 */
public class OrganPage extends Page implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 组织机构名称
     */
    private String organName;
    
    public String getOrganName() {
        return organName;
    }
    
    public void setOrganName(String organName) {
        this.organName = organName;
    }
    
}
