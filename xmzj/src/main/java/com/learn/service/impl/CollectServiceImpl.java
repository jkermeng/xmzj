package com.learn.service.impl;

import com.learn.dao.CollectDao;
import com.learn.entity.Collect;
import com.learn.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;
    @Override
    public Collect queryObject(Long id) {
        return collectDao.queryObject(id);
    }

    @Override
    public List<Collect> queryList(Map<String, Object> map) {
        return collectDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return collectDao.queryTotal(map);
    }

    @Override
    public void save(Collect project) {
        collectDao.save(project);
    }

    @Override
    public void update(Collect project) {
        collectDao.update(project);
    }

    @Override
    public void delete(Long id) {
        collectDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        collectDao.delete(ids);
    }
}
