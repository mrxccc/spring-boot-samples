package cn.mrxccc.cache.ehcache.mapper;

/**
 * @author mrxccc
 * @create 2021/1/11
 */

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;

import cn.mrxccc.cache.ehcache.domain.Student;


@Mapper
@CacheConfig(cacheNames = "student")
public interface StudentMapper {

    @Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    int update(Student student);

    @Delete("delete from student where sno=#{sno}")
    void deleteStudentBySno(String sno);

    @Select("select * from student where sno=#{sno}")
    @Results(id = "student", value = { @Result(property = "sno", column = "sno", javaType = String.class),
            @Result(property = "name", column = "sname", javaType = String.class),
            @Result(property = "sex", column = "ssex", javaType = String.class) })
    Student queryStudentBySno(String sno);
}
