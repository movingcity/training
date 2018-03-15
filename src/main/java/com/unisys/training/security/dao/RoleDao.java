/**
 * 
 */
package com.unisys.training.security.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.unisys.training.security.po.Role;
import com.unisys.training.security.po.User;

@Mapper
public interface RoleDao {
	@Insert("insert sys_roles (role, description, available) values (#{role}, #{description}, #{available})")
    public int createRole(Role aRole);
	
    @Delete("delete from sys_roles where id=#{roleId}")
	public int deleteRole(Long roleId);
    
	@Update("update sys_roles set role=#{role}, description=#{description}, available=#{available} where id=#{id}")
    public int updateRole(Role aRole);
	
    @Select("select * from sys_roles where id=#{roleId}")
    public User selectOneById(long roleId);
    
    @Select("select * from sys_roles where role=#{roleName}")
    public User selectOneByRoleName(String roleName);
    
    @Select("select count(role) from sys_roles where role=#{roleName}")
    public int getCountByRoleName(String roleName);
}
