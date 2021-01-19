package cn.mrxccc.shiro.service.impl;

import cn.mrxccc.shiro.domain.TbRole;
import cn.mrxccc.shiro.mapper.TbRoleMapper;
import cn.mrxccc.shiro.service.TbRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbRoleServiceImpl implements TbRoleService {

    @Resource
    private TbRoleMapper tbRoleMapper;

    @Override
    public List<TbRole> findByUserId(Long id) {
        return tbRoleMapper.findByUserId(id);
    }
}


