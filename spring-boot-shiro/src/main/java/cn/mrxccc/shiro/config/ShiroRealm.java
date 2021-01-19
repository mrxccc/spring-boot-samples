package cn.mrxccc.shiro.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.mrxccc.shiro.domain.TbUser;
import cn.mrxccc.shiro.mapper.TbUserMapper;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private TbUserMapper userMapper;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        TbUser user = userMapper.findByUserName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

}
