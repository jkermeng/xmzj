package com.learn.service.impl;

import com.learn.dao.U_DetailsDao;
import com.learn.entity.U_Details;
import com.learn.service.U_DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class U_DetailsServiceImpl implements U_DetailsService {
    @Autowired
    private U_DetailsDao u_detailsDao;

    @Override
    public U_Details queryObject(Long id) {
        return u_detailsDao.queryObject(id);
    }

    @Override
    public List<U_Details> queryList(Map<String, Object> map) {
        return u_detailsDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return u_detailsDao.queryTotal(map);
    }

    @Override
    public void save(U_Details test) {
        u_detailsDao.save(test);
    }

    @Override
    public void update(U_Details test) {
        u_detailsDao.update(test);
    }

    @Override
    public void delete(Long id) {
        u_detailsDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        u_detailsDao.deleteBatch(ids);
    }
}
