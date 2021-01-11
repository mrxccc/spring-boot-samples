package cn.mrxccc.multiple.datasource.jdbctemplate.service;

import cn.mrxccc.multiple.datasource.jdbctemplate.dao.LocalStudentDao;
import cn.mrxccc.multiple.datasource.jdbctemplate.dao.RemoteStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Service("studentService")
public class StudentService{
    @Autowired
    private RemoteStudentDao remoteStudentDao;
    @Autowired
    private LocalStudentDao localStudentDao;

    public List<Map<String, Object>> getAllStudentsFromRemote() {
        return this.remoteStudentDao.getAllStudents();
    }

    public List<Map<String, Object>> getAllStudentsFromLocal() {
        return this.localStudentDao.getAllStudents();
    }
}
