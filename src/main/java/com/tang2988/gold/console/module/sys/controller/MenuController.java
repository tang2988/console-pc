package com.tang2988.gold.console.module.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.tang2988.gold.console.common.action.BaseController;
import com.tang2988.gold.console.common.util.Exceptions;
import com.tang2988.gold.console.common.util.StringUtils;
import com.tang2988.gold.console.module.sys.dao.RoleDAO;
import com.tang2988.gold.console.module.sys.entity.SysMenu;
import com.tang2988.gold.console.module.sys.service.MenuService;

/**
 * 功能：菜单权限表
 *
 * @version 2016年12月26日下午4:43:47
 * @author baocheng.ren
 */
@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Resource
    private MenuService menuService;
    
    @Resource
    private RoleDAO roleDAO;
    
    /**
     * 功能：跳转到用户角色授权界面
     *
     * @version 2016年12月28日下午9:10:24
     * @author baocheng.ren
     * @param model 模型
     * @param roleIds id
     * @return String
     */
    @RequestMapping("roleAccreditUI")
    public String roleUserAccreditUI(Model model, String[] roleIds) {
        model.addAttribute("roleIds", StringUtils.join(roleIds, ","));
        return "modules/sys/role/role-accredit";
    }
    
    /**
     * 功能：查询所有的权限集合
     *
     * @version 2016年12月26日下午4:41:36
     * @author baocheng.ren
     * @param roleIds id
     * @return String
     */
    @RequestMapping("roleAccreditList")
    @ResponseBody
    public String roleAccreditList(String[] roleIds) {
        List<SysMenu> permissionList = this.menuService.findPermission(roleIds);
        return JSON.toJSONString(permissionList);
    }
    
    /**
     * 功能：保存角色的授权
     *
     * @version 2016年12月15日下午3:21:00
     * @author baocheng.ren
     * @param permissionIds 权限id
     * @param roleIds 角色id
     * @return String
     */
    @RequestMapping("savePermission")
    @ResponseBody
    public String savePermission(String[] permissionIds, String[] roleIds) {
        try {
            this.menuService.savePermission(permissionIds, roleIds);
        }
        catch (Exception e) {
            log.error(Exceptions.getStackTraceAsString(e));
            return "false";
        }
        return "true";
    }
    
}
