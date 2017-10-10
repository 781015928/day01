package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

import cn.itcast.mybatis.pojo.User;

/**
 * Created by czg on 2017/10/10.
 */

public class UserDaoImpl implements UserDao {
    SqlSessionFactory mSessionFactory;

    public UserDaoImpl(SqlSessionFactory sessionFactory) {
        mSessionFactory = sessionFactory;
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = mSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) throws Exception {
        SqlSession sqlSession = mSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByName", name);
        sqlSession.close();
        return users;
    }

    @Override
    public int insertUser(User user) throws Exception {
        SqlSession sqlSession = mSessionFactory.openSession();
        sqlSession.insert("test.insertUser", user);
        sqlSession.close();
        return user.getId();
    }

    @Override
    public int updateUser(User user) throws Exception {
        SqlSession sqlSession = mSessionFactory.openSession();
        int update = sqlSession.update("test.updateUserById", user);
        sqlSession.close();
        return update;
    }

    @Override
    public int deleteUser(int id) throws Exception {
        SqlSession sqlSession = mSessionFactory.openSession();
        int delete = sqlSession.delete("test.deleteUserById", id);
        sqlSession.close();
        return delete;
    }
}
