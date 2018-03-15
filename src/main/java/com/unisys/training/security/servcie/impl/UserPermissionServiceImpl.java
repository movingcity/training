package com.unisys.training.security.servcie.impl;

import com.unisys.training.security.dao.UserDao;
import com.unisys.training.security.dao.ViewUserPermissionDao;
import com.unisys.training.security.po.User;
import com.unisys.training.security.po.ViewUserPermission;
import com.unisys.training.security.servcie.UserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Autowired
    private ViewUserPermissionDao userPermissionDao;
    @Autowired
    private UserDao	userDao;

	@Override
	public List<ViewUserPermission> selectAllPermission(String userName) {
		User user = userDao.selectOneByUsername(userName);
		if (user == null || user.getLocked().booleanValue()) return null;
		
		List<ViewUserPermission> userPermissions = userPermissionDao.selectAll(userName);
		if(userPermissions == null || userPermissions.size()<=0) {
			return null;
		} else {
			return userPermissions;
		}	
	}
}
