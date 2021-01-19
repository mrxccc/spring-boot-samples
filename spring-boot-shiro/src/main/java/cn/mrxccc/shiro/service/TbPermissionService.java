package cn.mrxccc.shiro.service;

import cn.mrxccc.shiro.domain.TbPermission;

import java.util.List;

public interface TbPermissionService{


    List<TbPermission> findByUserById(Long id);
}
