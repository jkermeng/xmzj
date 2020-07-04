package com.learn.service.impl;

import com.learn.dao.StuffDao;
import com.learn.entity.ProjectEntity;
import com.learn.entity.Stuff;
import com.learn.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StuffServiceImpl implements StuffService {
    @Autowired
    private StuffDao stuffDao;

    @Override
    public Stuff queryObject(Long id) {
        return stuffDao.queryObject(id);
    }

    @Override
    public List<Stuff> queryList(Map<String, Object> map) {
        return stuffDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return stuffDao.queryTotal(map);
    }

    @Override
    public void save(Stuff project) {
        stuffDao.save(project);
    }

    @Override
    public void update(Stuff project) {
        stuffDao.update(project);
    }

    @Override
    public void delete(Long id) {
        stuffDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
            stuffDao.deleteBatch(ids);
    }
}
