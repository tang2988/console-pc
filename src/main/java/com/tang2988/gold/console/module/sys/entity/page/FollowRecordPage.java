package com.tang2988.gold.console.module.sys.entity.page;

import java.io.Serializable;

import com.tang2988.gold.console.common.entity.Page;

/**
 * 功能：跟进记录分页类
 *
 * @version 2017年1月19日上午10:22:26
 * @author baocheng.ren
 */
public class FollowRecordPage extends Page implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 客户id
     */
    private String customerId;
    
    public String getCustomerId() {
        return customerId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
}
