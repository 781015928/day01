package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import cn.itcast.mybatis.SqlSessionUtils;
import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.pojo.User;
import cn.itcast.mybatis.pojo.UserCustom;
import cn.itcast.mybatis.pojo.UserQueryVo;

/**
 * Created by czg on 2017/10/10.
 */

public class DaoTest {
    @Test
    public void findUserByName() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(SqlSessionUtils.getSqlSessionFactory());
        List<User> userByName = userDao.findUserByName("b");

        for (User user : userByName) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(10);
        System.out.println(user);
        User user2 = new User();
        user2.setUsername("" + (char) (Math.random() * 35535) + (char) (Math.random() * 35535) + (char) (Math.random() * 35535));
        user2.setBirthday(new Date());
        user2.setAddress("" + (char) (Math.random() * 35535) + (char) (Math.random() * 35535) + (char) (Math.random() * 35535));
        userMapper.insertUser(user2);
        sqlSession.commit();
        List<User> userByName = userMapper.findAll();
        userByName.forEach(user1 -> System.out.println(user1));
        sqlSession.close();
    }
    @Test
    public void findUserList() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("b");
        userCustom.setSex("男");
        userQueryVo.setUserCustom(userCustom);
        List<UserCustom> userList = userMapper.findUserList(userQueryVo);
    }
}
