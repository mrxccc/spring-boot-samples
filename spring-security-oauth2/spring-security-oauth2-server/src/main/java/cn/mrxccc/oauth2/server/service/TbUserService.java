package cn.mrxccc.oauth2.server.service;

import cn.mrxccc.oauth2.server.domain.TbUser;

public interface TbUserService{

    TbUser getByUserName(String username);
}
