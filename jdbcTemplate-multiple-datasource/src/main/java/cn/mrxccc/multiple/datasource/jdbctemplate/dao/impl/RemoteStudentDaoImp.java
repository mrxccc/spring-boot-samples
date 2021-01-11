package cn.mrxccc.multiple.datasource.jdbctemplate.dao.impl;

import cn.mrxccc.multiple.datasource.jdbctemplate.dao.RemoteStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Repository
public class RemoteStudentDaoImp implements RemoteStudentDao {
    @Autowired
    @Qualifier("remoteJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllStudents() {
        return this.jdbcTemplate.queryForList("select * from student");
    }
}
