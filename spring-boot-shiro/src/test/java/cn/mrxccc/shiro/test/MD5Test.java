package cn.mrxccc.shiro.test;

import cn.mrxccc.shiro.utils.MD5Utils;
import org.junit.Test;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
public class MD5Test {
    @Test
    public void Test1() {
        String encrypt = MD5Utils.encrypt("mrxccc", "123456");
        System.out.println(encrypt);
    }
}
