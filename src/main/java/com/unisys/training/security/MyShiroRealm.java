package com.unisys.training.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.unisys.training.security.po.User;
import com.unisys.training.security.po.ViewUserPermission;
import com.unisys.training.security.servcie.UserPermissionService;
import com.unisys.training.security.servcie.UserService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserPermissionService userPermissionService;
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		ViewUserPermission viewUserPermission = (ViewUserPermission) principals.getPrimaryPrincipal();
		List<ViewUserPermission> list0 = userPermissionService.selectAllPermission(viewUserPermission.getUsername());
		Set<String> set0 = new HashSet<String>();
		for (int i = 0; i < list0.size(); i++) {
			set0.add(list0.get(i).getPermission());
		}

		for (String permission : set0) {
			authorizationInfo.addStringPermission(permission);
			System.out.println("Added permission:" + permission);
		}
		return authorizationInfo;
	}

	/* 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		// 获取用户的输入的账号.
		String userName = (String) token.getPrincipal();
		System.out.println(token.getCredentials());
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		ViewUserPermission viewUserPermission = userPermissionService.selectAllPermission(userName).get(0);
		User user = userService.findByUsername(userName);
		
		// System.out.println("----->>userInfo="+userInfo);
		if (viewUserPermission == null) {
			return null;
		}
		// if (userInfo.getState() == 1) { //账户冻结
		// throw new LockedAccountException();
		// }
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				viewUserPermission, // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=username+salt
				userName + "R" // realm nama
		);
		return authenticationInfo;
	}

}
