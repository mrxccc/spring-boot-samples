package cn.mrxccc.shiro.service;

import cn.mrxccc.shiro.domain.TbRole;

import java.util.List;

public interface TbRoleService{


    List<TbRole> findByUserId(Long id);
}
