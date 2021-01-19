package cn.mrxccc.shiro.mapper;

import cn.mrxccc.shiro.domain.TbUser;
import tk.mybatis.mapper.MyMapper;

public interface TbUserMapper extends MyMapper<TbUser> {
    TbUser findByUserName(String userName);
}