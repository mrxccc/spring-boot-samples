package cn.mrxccc.oauth2.server.config.service;

import cn.mrxccc.oauth2.server.domain.TbPermission;
import cn.mrxccc.oauth2.server.domain.TbUser;
import cn.mrxccc.oauth2.server.service.TbPermissionService;
import cn.mrxccc.oauth2.server.service.TbUserService;
import java.util.List;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author mrxccc
 * @create 2020/11/27
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUserName(userName);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(simpleGrantedAuthority);
            });
        }
        return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
    }
}
