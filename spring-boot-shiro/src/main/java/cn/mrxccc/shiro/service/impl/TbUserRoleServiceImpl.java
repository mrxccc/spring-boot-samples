package cn.mrxccc.shiro.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.mrxccc.shiro.mapper.TbUserRoleMapper;
import cn.mrxccc.shiro.service.TbUserRoleService;

@Service
public class TbUserRoleServiceImpl implements TbUserRoleService {

    @Resource
    private TbUserRoleMapper tbUserRoleMapper;

}


