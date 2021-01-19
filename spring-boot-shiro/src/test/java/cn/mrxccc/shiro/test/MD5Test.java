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
        String adminEncrypt = MD5Utils.encrypt("admin", "123456");
        String testEncrypt = MD5Utils.encrypt("test", "123456");
        System.out.println("admin:" + adminEncrypt);
        System.out.println("test:" + testEncrypt);
    }
}
