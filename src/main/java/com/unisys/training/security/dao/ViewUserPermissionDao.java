package com.unisys.training.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.unisys.training.security.po.ViewUserPermission;

@Mapper
public interface ViewUserPermissionDao {
    @Select("select * from view_users_permissions where username = #{userName}")
    public List<ViewUserPermission> selectAll(String userName);
}
