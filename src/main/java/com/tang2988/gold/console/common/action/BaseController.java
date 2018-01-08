package com.tang2988.gold.console.common.action;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import javax.validation.Validator;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.tang2988.gold.console.common.util.DateUtils;

/**
 * 类功能介绍
 * 
 * @version 2016年3月11日下午5:12:29
 * @author du.dxlove
 */
public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * 验证Bean实例对象
     */
    @Autowired
    protected Validator validator;
    
    /**
     * 功能：初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
     *
     * @version 2016年12月28日下午9:37:56
     * @author baocheng.ren
     * @param binder binder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
            }
            
            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });
        
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }
    
}
