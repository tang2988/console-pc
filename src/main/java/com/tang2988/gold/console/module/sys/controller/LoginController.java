package com.tang2988.gold.console.module.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tang2988.gold.common.utils.MD5;
import com.tang2988.gold.console.common.action.BaseController;
import com.tang2988.gold.console.module.sys.entity.ShiroUser;
import com.tang2988.gold.console.module.sys.service.SysUserService;

/**
 * 功能：登录处理
 *
 * @version 2016年12月27日下午7:17:39
 * @author baocheng.ren
 */
@Controller
public class LoginController extends BaseController {
    
    /**
     * 用户service
     */
    @Autowired
    private SysUserService sysUserService;
    
    /**
     * 功能：首页地址
     *
     * @version 2016年9月23日下午2:45:13
     * @author baocheng.ren
     * @return String
     */
    @RequestMapping(value = { "index", "" })
    public String index() {
        return "modules/index";
    }
    
    /**
     * 功能：登录地址
     *
     * @version 2016年9月23日下午2:45:50
     * @author baocheng.ren
     * @return String
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "modules/login";
    }
    
    /**
     * 功能：登录验证
     *
     * @version 2016年9月23日下午2:46:13
     * @author baocheng.ren
     * @param request 请求
     * @param model 模型
     * @return String
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        ShiroUser user = sysUserService.getByLoginName(request.getParameter("username"));
        String pwd = request.getParameter("username");
        if (user != null) {
            if (!user.getPassword().equalsIgnoreCase(MD5.toDigest(pwd))) {
                model.addAttribute("loginerror", "用户名或密码错误！");
            }
            else {
                return "modules/index";
                //model.addAttribute("loginerror", "用户名或密码错误！");
            }
        }
        
        // 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        // 登陆失败还到login页面
        return "modules/login";
    }
    
}
