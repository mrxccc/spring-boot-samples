package cn.mrxccc.shiro.service.impl;

import cn.mrxccc.shiro.domain.TbPermission;
import cn.mrxccc.shiro.mapper.TbPermissionMapper;
import cn.mrxccc.shiro.service.TbPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<TbPermission> findByUserById(Long id) {
        return tbPermissionMapper.findByUserById(id);
    }
}


