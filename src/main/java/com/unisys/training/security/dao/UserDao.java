/**
 * 
 */
package com.unisys.training.security.dao;

import com.unisys.training.security.po.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    @Insert("insert into sys_users(username, salt, password, locked)" +
            " values (#{username}, #{salt}, #{password}, #{locked})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int userInsert(User user);

    @Update("update sys_users set password=#{password}, salt=#{salt}, username=#{username}, locked=#{locked} where id=#{id}")
    public int userUpdate(User user);
    
    @Delete("delete from sys_users where id=#{userId}")
    public void deleteUser(Long userId);

    @Select("select * from sys_users where id=#{userId}")
    public User selectOneById(long userId);
    
    @Select("select * from sys_users where username=#{username}")
    public User selectOneByUsername(String username);
    
    @Select("select count(usernae) from sys_users where username=#{username}")
    public int getCountByUsername(String username);
}