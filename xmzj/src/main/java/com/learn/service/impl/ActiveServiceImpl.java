package com.learn.service.impl;

import com.learn.dao.ActiveDao;
import com.learn.entity.Active;
import com.learn.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private ActiveDao activeDao;
    @Override
    public Active queryObject(Long id) {
        return activeDao.queryObject(id);
    }

    @Override
    public List<Active> queryList(Map<String, Object> map) {
        return activeDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activeDao.queryTotal(map);
    }

    @Override
    public void save(Active project) {
        activeDao.save(project);
    }

    @Override
    public void update(Active project) {
        activeDao.update(project);
    }

    @Override
    public void delete(Long id) {
        activeDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        activeDao.deleteBatch(ids);
    }
}
