package cn.mrxccc.aop.log.dao;

import cn.mrxccc.aop.log.domain.SysLog;

/**
 * @author mrxccc
 * @create 2021/1/11
 */
public interface SysLogDao {
    void saveSysLog(SysLog syslog);
}
