package cn.mrxccc.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequiresPermissions("SystemUserView")
    @RequestMapping("list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        return "user";
    }

    @RequiresPermissions("SystemUserInsert")
    @RequestMapping("add")
    public String userAdd(Model model) {
        model.addAttribute("value", "新增用户");
        return "user";
    }

    @RequiresPermissions("SystemUserDelete")
    @RequestMapping("delete")
    public String userDelete(Model model) {
        model.addAttribute("value", "删除用户");
        return "user";
    }
}
