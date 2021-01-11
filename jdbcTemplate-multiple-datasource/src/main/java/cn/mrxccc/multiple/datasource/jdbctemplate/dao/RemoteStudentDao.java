package cn.mrxccc.multiple.datasource.jdbctemplate.dao;

import java.util.List;
import java.util.Map;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
public interface RemoteStudentDao {
    List<Map<String, Object>> getAllStudents();
}
