package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


import com.learn.dao.TestDao;
import com.learn.entity.TestEntity;
import com.learn.service.TestService;
import com.learn.service.*;


@Service("testService")
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;


    @Autowired
    private TypeService typeService;


    @Override
    public TestEntity queryObject(Long id) {
        TestEntity entity = testDao.queryObject(id);


        if (entity.getType() != null && this.typeService.queryObject(entity.getType()) != null)
            entity.setTypeEntity(this.typeService.queryObject(entity.getType()));


        return entity;
    }

    @Override
    public List<TestEntity> queryList(Map<String, Object> map) {
        List<TestEntity> list = testDao.queryList(map);
        for (TestEntity entity : list) {

            if (entity.getType() != null && this.typeService.queryObject(entity.getType()) != null)
                entity.setTypeEntity(this.typeService.queryObject(entity.getType()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return testDao.queryTotal(map);
    }

    @Override
    public void save(TestEntity test) {
        testDao.save(test);
    }

    @Override
    public void update(TestEntity test) {
        testDao.update(test);
    }

    @Override
    public void delete(Long id) {
        testDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        testDao.deleteBatch(ids);
    }

}
