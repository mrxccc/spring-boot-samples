package cn.mrxccc.shiro.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.mrxccc.shiro.mapper.TbPermissionMapper;
import cn.mrxccc.shiro.service.TbPermissionService;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

}


