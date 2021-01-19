package cn.mrxccc.shiro.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.mrxccc.shiro.mapper.TbUserMapper;
import cn.mrxccc.shiro.service.TbUserService;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

}


