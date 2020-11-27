package cn.mrxccc.oauth2.server.service;

import cn.mrxccc.oauth2.server.domain.TbPermission;
import java.util.List;

public interface TbPermissionService{
    List<TbPermission> selectByUserId(Long userId);

}
