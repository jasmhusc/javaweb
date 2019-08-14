package com.hsc.dao;

import com.hsc.entity.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/*
    User的dao接口
 */
public interface IUserDao {

    // 查询所有用户
    @Select("SELECT * FROM user;")
    List<User> findAllUsers();
}
