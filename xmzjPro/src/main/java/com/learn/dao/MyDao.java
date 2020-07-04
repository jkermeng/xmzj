package com.learn.dao;

import java.util.List;

public interface MyDao<T> {
    List<T> selectAll();

    T selectOneByKey(T t);

    T selectById(Integer id);

    Integer update(T t);

    Integer delete(T t);
    Integer deleteByList(List list);
    Integer insert(T t);

    boolean exist(T t);
}
