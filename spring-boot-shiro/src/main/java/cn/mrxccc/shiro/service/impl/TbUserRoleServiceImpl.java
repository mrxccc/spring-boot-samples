package cn.mrxccc.shiro.service.impl;

import cn.mrxccc.shiro.mapper.TbUserRoleMapper;
import cn.mrxccc.shiro.service.TbUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbUserRoleServiceImpl implements TbUserRoleService {

    @Resource
    private TbUserRoleMapper tbUserRoleMapper;

}


