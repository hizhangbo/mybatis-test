package com.zqdt.weibo.repository.mapper;

/**
 * Created by zhangbo on 2017/6/27.
 */
public interface BaseMapper<T> {

    T getById(Long id);

    void insert(T model);

    void update(T model);

    void delete(Long id);
}
