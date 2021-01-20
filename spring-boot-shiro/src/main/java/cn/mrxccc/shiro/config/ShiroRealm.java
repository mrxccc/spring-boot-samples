package cn.mrxccc.shiro.config;

import cn.mrxccc.shiro.domain.TbPermission;
import cn.mrxccc.shiro.domain.TbRole;
import cn.mrxccc.shiro.domain.TbUser;
import cn.mrxccc.shiro.service.TbPermissionService;
import cn.mrxccc.shiro.service.TbRoleService;
import cn.mrxccc.shiro.service.TbUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author mrxccc
 * @create 2021/1/19
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbRoleService tbRoleService;

    @Autowired
    private TbPermissionService tbPermissionService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        TbUser user = (TbUser) SecurityUtils.getSubject().getPrincipal();
        log.info("用户" + user.getId() + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 获取用户角色集
        List<TbRole> roleList = tbRoleService.findByUserId(user.getId());
        Set<String> roleSet = new HashSet<String>();
        for (TbRole r : roleList) {
            roleSet.add(r.getName());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<TbPermission> permissionList = tbPermissionService.findByUserById(user.getId());
        Set<String> permissionSet = new HashSet<String>();
        for (TbPermission p : permissionList) {
            permissionSet.add(p.getEnname());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名密码 第一种方式
        //String username = (String) authenticationToken.getPrincipal();
        //String password = new String((char[]) authenticationToken.getCredentials());

        //获取用户名 密码 第二种方式
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();
        String passWord = new String(usernamePasswordToken.getPassword());

        log.info("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        TbUser user = tbUserService.findByUserName(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!passWord.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, passWord, getName());
        return info;
    }

}
