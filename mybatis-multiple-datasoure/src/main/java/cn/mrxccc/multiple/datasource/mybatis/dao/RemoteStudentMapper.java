package cn.mrxccc.multiple.datasource.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Mapper
public interface RemoteStudentMapper {
    List<Map<String, Object>> getAllStudents();
}
