package com.example.yin.dao;

import com.example.yin.pojo.User;
import com.example.yin.pojo.vo.UserDefine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User selectUserByAccount(@Param("account") String account);

    int insertUser(@Param("account")String account, @Param("password") String password);

    int updateUserById(UserDefine userDefine);

    List<User> selectAllUsers();
}
