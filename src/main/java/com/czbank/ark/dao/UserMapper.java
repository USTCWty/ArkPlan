package com.czbank.ark.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.User;
@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user (user_name, user_Password,user_role,submit_time) VALUES (#{userName}, #{userPassword}, #{userRole},#{submitTime})")
    int addUser(User user);
    
    @Select("select count(*) from user ")
    int countAllUser();
    
   // @Select("select * from user where user_name=#{username}")
    List<User> selectUserByName(String name);
    
    @Select("select * from user where user_id =#{id}")
    User selectUserById(Integer id);
}