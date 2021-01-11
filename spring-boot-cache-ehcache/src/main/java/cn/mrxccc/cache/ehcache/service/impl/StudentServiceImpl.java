package cn.mrxccc.cache.ehcache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mrxccc.cache.ehcache.domain.Student;
import cn.mrxccc.cache.ehcache.mapper.StudentMapper;
import cn.mrxccc.cache.ehcache.service.StudentService;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Repository("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student update(Student student) {
        this.studentMapper.update(student);
        return this.studentMapper.queryStudentBySno(student.getSno());
    }

    @Override
    public void deleteStudentBySno(String sno) {
        this.studentMapper.deleteStudentBySno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }

}
