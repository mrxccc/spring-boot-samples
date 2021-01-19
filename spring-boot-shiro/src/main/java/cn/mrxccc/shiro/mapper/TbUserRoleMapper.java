package cn.mrxccc.shiro.mapper;

import cn.mrxccc.shiro.domain.TbRole;
import cn.mrxccc.shiro.domain.TbUserRole;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbUserRoleMapper extends MyMapper<TbUserRole> {
    List<TbRole> findByUserId(Long id);
}