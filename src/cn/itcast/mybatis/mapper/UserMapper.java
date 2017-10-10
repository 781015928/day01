package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.pojo.User;
import cn.itcast.mybatis.pojo.UserCustom;
import cn.itcast.mybatis.pojo.UserQueryVo;

/**
 * Created by czg on 2017/10/10.
 */

public interface UserMapper {

    User findUserById(int id) throws Exception;

    List<User> findUserByName(String name) throws Exception;

    List<User> findAll() throws Exception;

    void insertUser(User user) throws Exception;

    void updateUserById(User user) throws Exception;

    void deleteUserById(int id) throws Exception;


    List<UserCustom> findUserList(UserQueryVo userQueryVo)throws Exception;


}
