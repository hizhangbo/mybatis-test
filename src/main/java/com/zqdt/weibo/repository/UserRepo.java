package com.zqdt.weibo.repository;

import com.zqdt.weibo.repository.mapper.UserMapper;
import com.zqdt.weibo.repository.model.User;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by zhangbo on 2017/6/27.
 */
public class UserRepo extends BaseRepo<User> {

    private UserMapper userMapper = null;

    @Override
    public User getById(Long id) {
        SqlSession sqlSession = this.createSqlSession();

        try{
            userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getById(id);
        }finally{
            sqlSession.close();
        }
    }

    @Override
    public void insert(User user) {
        SqlSession sqlSession = this.createSqlSession();
        try {
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.insert(user);
            sqlSession.commit();
        } catch(Exception ex){
            sqlSession.rollback();
            throw ex;
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = this.createSqlSession();
        try{
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.update(user);
            sqlSession.commit();
        } catch(Exception ex){
            sqlSession.rollback();
            throw ex;
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public void delete(Long id) {
        SqlSession sqlSession = this.createSqlSession();
        try{
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.delete(id);
            sqlSession.commit();
        } catch(Exception ex){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
