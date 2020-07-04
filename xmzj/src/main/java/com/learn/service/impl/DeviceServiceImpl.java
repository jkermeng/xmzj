package com.learn.service.impl;

import com.learn.dao.DeviceDao;
import com.learn.entity.Device;
import com.learn.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Override
    public Device queryObject(Long id) {
        return deviceDao.queryObject(id);
    }

    @Override
    public List<Device> queryList(Map<String, Object> map) {
        return deviceDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return deviceDao.queryTotal(map);
    }

    @Override
    public void save(Device project) {
        deviceDao.save(project);
    }

    @Override
    public void update(Device project) {
        deviceDao.update(project);
    }

    @Override
    public void delete(Long id) {
        deviceDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        deviceDao.deleteBatch(ids);
    }
}
