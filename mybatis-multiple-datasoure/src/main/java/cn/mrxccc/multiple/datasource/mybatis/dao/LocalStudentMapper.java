package cn.mrxccc.multiple.datasource.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Mapper
public interface LocalStudentMapper {
    List<Map<String, Object>> getAllStudents();
}
