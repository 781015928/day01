package cn.itcast.mybatis.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import cn.itcast.mybatis.SqlSessionUtils;
import cn.itcast.mybatis.pojo.User;

/**
 * Created by czg on 2017/10/10.
 */

public class MybatisFirst {
    private static SqlSession getSqlSession() {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return sessionFactory.openSession();
    }


    @Test
    public void findUserById() throws IOException {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void findUserByName() throws IOException {
        SqlSession sqlSession = getSqlSession();

        List<User> users = sqlSession.selectList("test.findUserByName", "小明");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void addUser() throws IOException {
        SqlSession sqlSession = getSqlSession();
        User user = new User();
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("bbbb");
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.openSession();
        User user = new User();
        user.setAddress("北京");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("bbbb");
        user.setId(10);
        sqlSession.update("test.updateUserById", user);
        sqlSession.commit();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws IOException {
        SqlSession sqlSession = getSqlSession();
        sqlSession.delete("test.deleteUserById", 10);
        sqlSession.commit();
        sqlSession.close();
    }
}
