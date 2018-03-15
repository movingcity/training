package com.unisys.training.security.servcie;


import com.unisys.training.security.po.ViewUserPermission;

import java.util.List;

public interface UserPermissionService {

    public List<ViewUserPermission> selectAllPermission(String userName);
}
