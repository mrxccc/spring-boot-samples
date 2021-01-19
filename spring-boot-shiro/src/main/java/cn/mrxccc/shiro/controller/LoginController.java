package cn.mrxccc.shiro.controller;

import cn.mrxccc.shiro.domain.TbUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mrxccc.shiro.dto.ResponseDto;
import cn.mrxccc.shiro.utils.MD5Utils;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseDto login(String username, String password, Boolean rememberMe) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseDto.ok();
        } catch (UnknownAccountException e) {
            return ResponseDto.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseDto.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResponseDto.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseDto.error("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        TbUser user = (TbUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }
}
