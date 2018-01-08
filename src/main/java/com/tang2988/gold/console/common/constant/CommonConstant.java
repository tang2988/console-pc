package com.tang2988.gold.console.common.constant;

/**
 * 功能：用到的常量
 *
 * @version 2016年9月23日下午3:03:10
 * @author baocheng.ren
 */
public abstract class CommonConstant {
    /**
     * 用户名键值
     */
    public static final String USER_NAME = "username";
    
    /**
     * 验证码保存在session中的键值
     */
    public static final String VALIDATE_CODE_SESSION_KEY = "validateCode";
    
    /**
     * 登录界面传递的获取验证码参数值
     */
    public static final String VALIDATE_CODE_PARAMETER = "validateCode";
    
    /**
     * 验证码输入错误时，设置验证码错误时的名称
     */
    public static final String VALIDATE_CODE_ERROR_VALUE = "randomCodeError";
    
    /**
     * 公章路径
     */
    public static final String HSDGOLD_SEAL_PATH = "/static/images/hsdgold_seal.png";
    
    /**
     * 电销人员查询标记
     */
    public static final String TELEMARKETER_QUERY_FLAG ="telemarketerQuery";
    
}
