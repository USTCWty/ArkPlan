package com.czbank.ark.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Repository;

import com.czbank.ark.model.User;
@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select count(*) from user ")
    int countAllUser();
    
   // @Select("select * from user where user_name=#{username}")
    List<User> selectUserByName(String name);
    
    @Select("select * from user where user_id =#{id}")
    User selectUserById(Integer id);
}