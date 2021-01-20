package cn.mrxccc.shiro.service;

import cn.mrxccc.shiro.bo.UserOnline;

import java.util.List;

/**
 * @author mrxccc
 * @create 2021/1/20
 */
public interface SessionService {
    List<UserOnline> list();
    boolean forceLogout(String sessionId);
}
