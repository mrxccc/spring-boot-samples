package cn.mrxccc.cache.redis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -339516038496531943L;
    private String sno;
    private String name;
    private String sex;
}
