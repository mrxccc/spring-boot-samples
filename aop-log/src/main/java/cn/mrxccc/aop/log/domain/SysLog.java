package cn.mrxccc.aop.log.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = -6309732882044872298L;

    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private LocalDateTime createTime;
}
