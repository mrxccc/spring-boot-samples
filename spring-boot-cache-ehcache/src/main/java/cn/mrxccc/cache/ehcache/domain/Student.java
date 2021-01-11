package cn.mrxccc.cache.ehcache.domain;

import java.io.Serializable;

import lombok.Data;

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
