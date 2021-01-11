package cn.mrxccc.multiple.datasource.mybatis.service;

import java.util.List;
import java.util.Map;

import cn.mrxccc.multiple.datasource.mybatis.dao.LocalStudentMapper;
import cn.mrxccc.multiple.datasource.mybatis.dao.RemoteStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Service("studentService")
public class StudentService{
    @Autowired
    private RemoteStudentMapper remoteStudentDao;
    @Autowired
    private LocalStudentMapper localStudentDao;

    public List<Map<String, Object>> getAllStudentsFromRemote() {
        return this.remoteStudentDao.getAllStudents();
    }

    public List<Map<String, Object>> getAllStudentsFromLocal() {
        return this.localStudentDao.getAllStudents();
    }
}
