package cn.mrxccc.multiple.datasource.mybatis.controller;

import java.util.List;
import java.util.Map;

import cn.mrxccc.multiple.datasource.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author mrxccc
 * @create 2021/1/11
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("querystudentsfromremote")
    public List<Map<String, Object>> queryStudentsFromRemote(){
        return this.studentService.getAllStudentsFromRemote();
    }

    @RequestMapping("querystudentsfromlocal")
    public List<Map<String, Object>> queryStudentsFromLocal(){
        return this.studentService.getAllStudentsFromLocal();
    }
}
