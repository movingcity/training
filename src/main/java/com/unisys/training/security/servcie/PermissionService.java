/**
 * 
 */
package com.unisys.training.security.servcie;

import com.unisys.training.security.po.Permission;

/**
 * @author LiuJ2
 *
 */
public interface PermissionService {
	public Permission createPermission(Permission permission);
	public void deletePermission(Long permissionId);
}
