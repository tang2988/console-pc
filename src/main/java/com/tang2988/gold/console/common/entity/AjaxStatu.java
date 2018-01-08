package com.tang2988.gold.console.common.entity;

/**
 * ajax消息
 * 
 * @version 2017年1月5日下午5:17:43
 * @author dx.love
 */
public enum AjaxStatu {
    /** 常量的定义 */
    SUCCESS("200", "成功"), 
    /** 常量的定义 */
    ERROR_INPUT("100", "参数不合法"),
    /** 常量的定义 */
    ERROR_VERIFICATION_CODE("101", "验证码不正确"),
    /** 常量的定义 */
    SERVER_ERROR("9999", "服务器异常");
    // 成员变量
    private String value;
    private String msg;
    
    private AjaxStatu(String value, String msg) {
        this.value = value;
        this.msg = msg;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * 重写toString方法
     * 
     * @return 结果
     */
    public String toString() {
        return this.value;
    }
}
