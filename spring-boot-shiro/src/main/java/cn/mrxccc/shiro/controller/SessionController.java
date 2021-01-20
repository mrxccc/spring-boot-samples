package cn.mrxccc.shiro.controller;

import cn.mrxccc.shiro.bo.UserOnline;
import cn.mrxccc.shiro.dto.ResponseDto;
import cn.mrxccc.shiro.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author mrxccc
 * @create 2021/1/20
 */
@Controller
@RequestMapping("/online")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @RequestMapping("index")
    public String online() {
        return "online";
    }

    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }

    @ResponseBody
    @RequestMapping("forceLogout")
    public ResponseDto forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return ResponseDto.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.error("踢出用户失败");
        }
    }
}
