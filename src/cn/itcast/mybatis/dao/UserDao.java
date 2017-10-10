package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

/**
 * Created by czg on 2017/10/10.
 */

public interface UserDao {

    User findUserById(int id) throws Exception;


    List<User> findUserByName(String name) throws Exception;


    int insertUser(User user) throws Exception;


    int updateUser(User user) throws Exception;


    int deleteUser(int id) throws Exception;
}
