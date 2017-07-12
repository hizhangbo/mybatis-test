package com.zqdt.weibo.repository;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhangbo on 2017/6/27.
 */
public abstract class BaseRepo<T> {

    private SqlSession session;
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            if(sqlSessionFactory == null){
                InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSession createSqlSession(){
        session = sqlSessionFactory.openSession();
        return session;
    }

    public abstract T getById(Long id);
    public abstract void insert(T model);
    public abstract void update(T model);
    public abstract void delete(Long id);
}
