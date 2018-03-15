/**
 * 
 */
package com.unisys.training.security.servcie.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unisys.training.security.dao.UserDao;
import com.unisys.training.security.po.User;
import com.unisys.training.security.servcie.PasswordHelper;
import com.unisys.training.security.servcie.UserService;

/**
 * @author LiuJ2
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	private PasswordHelper passwordHelper = new PasswordHelper();
	
	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#createUser(com.unisys.training.security.po.User)
	 */
	@Override
	public User createUser(User user) {
		passwordHelper.encryptPassword(user);
		userDao.userInsert(user);
		if(user.getId()>0) {
			return user;
		} else {
			System.out.println("Failed to create user! Please check!");
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#changePassword(java.lang.Long, java.lang.String)
	 */
	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#correlationRoles(java.lang.Long, java.lang.Long[])
	 */
	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#uncorrelationRoles(java.lang.Long, java.lang.Long[])
	 */
	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#findRoles(java.lang.String)
	 */
	@Override
	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.unisys.training.security.servcie.UserService#findPermissions(java.lang.String)
	 */
	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
