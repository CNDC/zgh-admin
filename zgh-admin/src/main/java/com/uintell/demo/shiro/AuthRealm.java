package com.uintell.demo.shiro;

import com.uintell.demo.bean.Admin;
import com.uintell.demo.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author chenjm1
 * @since 2017/11/13
 */
@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      /*  System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        Admin token = (Admin) SecurityUtils.getSubject().getPrincipal();
        String id = token.getId();*/
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
    /*Map<String, Object> map = new HashMap<String, Object>();
    map.put("user_id", userId);
    List<SysRole> roleList = sysRoleService.selectByMap(map);
    Set<String> roleSet = new HashSet<String>();
    for(SysRole role : roleList){
        roleSet.add(role.getType());
    }
        //实际开发，当前登录用户的角色和权限信息是从数据库来获取的，我这里写死是为了方便测试
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
    List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
    Set<String> permissionSet = new HashSet<String>();
    for(SysPermission Permission : permissionList){
        permissionSet.add(Permission.getName());
    }
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        info.setStringPermissions(permissionSet);*/
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Map<String, Object> map = new HashMap<>();
        map.put("username", token.getUsername());
        map.put("password", token.getPassword());
        Admin admin = null;
        // 从数据库获取对应用户名密码的用户
        List<Admin> userList = adminService.selectByMap(map);
        if (userList.size() != 0) {
            admin = userList.get(0);
        }
        if (null == admin) {
            throw new AccountException("帐号或密码不正确！");
        } else if (admin.getStatus() == 0) {
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
            throw new DisabledAccountException("帐号已经禁止登录！");
        } else {
            //更新登录时间 last login time
            //admin.setLastLoginTime(new Date());
            adminService.updateById(admin);
        }
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), getName());

    }
}
