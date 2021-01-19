package cn.mrxccc.shiro.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.mrxccc.shiro.mapper.TbRoleMapper;
import cn.mrxccc.shiro.service.TbRoleService;

@Service
public class TbRoleServiceImpl implements TbRoleService {

    @Resource
    private TbRoleMapper tbRoleMapper;

}


