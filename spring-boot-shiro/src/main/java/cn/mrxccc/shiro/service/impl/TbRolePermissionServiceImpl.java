package cn.mrxccc.shiro.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.mrxccc.shiro.mapper.TbRolePermissionMapper;
import cn.mrxccc.shiro.service.TbRolePermissionService;

@Service
public class TbRolePermissionServiceImpl implements TbRolePermissionService {

    @Resource
    private TbRolePermissionMapper tbRolePermissionMapper;

}


