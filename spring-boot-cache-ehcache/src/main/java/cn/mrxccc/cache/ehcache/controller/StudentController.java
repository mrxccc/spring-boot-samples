package cn.mrxccc.cache.ehcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mrxccc.cache.ehcache.domain.Student;
import cn.mrxccc.cache.ehcache.service.StudentService;


/**
 * @author mrxccc
 * @create 2021/1/11
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("queryStudentBySno/{sno}")
    public Student queryStudentBySno(@PathVariable("sno") String sno){
        return this.studentService.queryStudentBySno(sno);
    }

    @RequestMapping("update")
    public void update(){
        Student student1 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

        Student student2 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
    }

    @RequestMapping("deleteStudentBySno")
    public void deleteStudentBySno(String sno){
        this.studentService.deleteStudentBySno(sno);
    }

}
