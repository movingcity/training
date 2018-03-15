/**
 * 
 */
package com.unisys.training.security.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.unisys.training.security.dao.RoleDao;
import com.unisys.training.security.po.Role;
import com.unisys.training.security.servcie.RoleService;

/**
 * @author LiuJ2
 *
 */
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.unisys.training.security.servcie.RoleService#createRole(com.unisys.
	 * training.security.po.Role)
	 */
	@Override
	public Role createRole(Role role) {
		roleDao.createRole(role);
		if (role.getId() > 0) {
			return role;
		} else {
			System.out.println("Failed to create role! Please check!");
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.unisys.training.security.servcie.RoleService#deleteRole(java.lang.Long)
	 */
	@Override
	public void deleteRole(Long roleId) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.unisys.training.security.servcie.RoleService#correlationPermissions(java.
	 * lang.Long, java.lang.Long[])
	 */
	@Override
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.unisys.training.security.servcie.RoleService#uncorrelationPermissions(
	 * java.lang.Long, java.lang.Long[])
	 */
	@Override
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public Role updateRole(Role role) {
		int ret = roleDao.updateRole(role);
		if (ret > 0) {
			return role;
		} else {
			return null;
		}
	}

}
