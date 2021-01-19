package cn.mrxccc.shiro.mapper;

import cn.mrxccc.shiro.domain.TbPermission;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission> findByUserById(Long id);
}