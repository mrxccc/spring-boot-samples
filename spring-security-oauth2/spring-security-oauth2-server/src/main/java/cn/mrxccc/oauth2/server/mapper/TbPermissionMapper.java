package cn.mrxccc.oauth2.server.mapper;

import cn.mrxccc.oauth2.server.domain.TbPermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}