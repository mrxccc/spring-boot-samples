package cn.mrxccc.shiro.service.impl;

import cn.mrxccc.shiro.domain.TbUser;
import cn.mrxccc.shiro.mapper.TbUserMapper;
import cn.mrxccc.shiro.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser findByUserName(String userName) {
        return tbUserMapper.findByUserName(userName);
    }
}


