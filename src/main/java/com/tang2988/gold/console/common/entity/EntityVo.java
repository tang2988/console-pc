package com.tang2988.gold.console.common.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体对象VO
 * @version 2016-12-23上午10:44:07
 * @author xiaoyun.zeng
 */
public class EntityVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
