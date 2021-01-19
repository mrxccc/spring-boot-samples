package cn.mrxccc.shiro.service;

import cn.mrxccc.shiro.domain.TbUser;

public interface TbUserService{
    TbUser findByUserName(String userName);
}
