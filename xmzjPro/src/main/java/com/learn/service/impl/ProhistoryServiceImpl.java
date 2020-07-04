package com.learn.service.impl;

import com.learn.dao.ProhistoryDao;
import com.learn.entity.Prohistory;
import com.learn.service.ProhistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProhistoryServiceImpl implements ProhistoryService {
    @Autowired
    private ProhistoryDao prohistoryDao;

    @Override
    public Prohistory queryObject(Long id) {
        return prohistoryDao.queryObject(id);
    }

    @Override
    public List<Prohistory> queryList(Map<String, Object> map) {
        return prohistoryDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return prohistoryDao.queryTotal(map);
    }

    @Override
    public void save(Prohistory project) {
        prohistoryDao.save(project);
    }

    @Override
    public void update(Prohistory project) {
        prohistoryDao.update(project);
    }

    @Override
    public void delete(Long id) {
        prohistoryDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        prohistoryDao.deleteBatch(ids);
    }
}
