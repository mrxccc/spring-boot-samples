package cn.mrxccc.shiro.mapper;

import cn.mrxccc.shiro.domain.TbRole;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbRoleMapper extends MyMapper<TbRole> {
    List<TbRole> findByUserId(Long id);
}