package com.learn.service.impl;

import com.learn.dao.JoinActiveDao;
import com.learn.entity.JoinActive;
import com.learn.service.JoinActiveService;
import com.learn.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class JoinActiveServiceImpl implements JoinActiveService {
    @Autowired
    private JoinActiveDao joinActiveDao;

    @Override
    public JoinActive queryObject(Long id) {
        return joinActiveDao.queryObject(id);
    }

    @Override
    public List<JoinActive> queryList(Map<String, Object> map) {
        return joinActiveDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return joinActiveDao.queryTotal(map);
    }

    @Override
    public void save(JoinActive project) {
        project.setJoinDate(DateUtils.format(new Date()));
        joinActiveDao.save(project);
    }

    @Override
    public void update(JoinActive project) {
        joinActiveDao.update(project);
    }

    @Override
    public void delete(Long id) {
        joinActiveDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        joinActiveDao.deleteBatch(ids);
    }
}
