package com.learn.service.impl;

import com.learn.dao.A_ImgDao;
import com.learn.entity.A_Img;
import com.learn.service.A_ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class A_ImgServiceImpl implements A_ImgService {
    @Autowired
    private A_ImgDao a_imgDao;
    @Override
    public A_Img queryObject(Long id) {
        return a_imgDao.queryObject(id);
    }

    @Override
    public List<A_Img> queryList(Map<String, Object> map) {
        return a_imgDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return a_imgDao.queryTotal(map);
    }

    @Override
    public void save(A_Img project) {
    a_imgDao.save(project);
    }

    @Override
    public void update(A_Img project) {
        a_imgDao.update(project);
    }

    @Override
    public void delete(Long id) {
        a_imgDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        a_imgDao.deleteBatch(ids);
    }
}
