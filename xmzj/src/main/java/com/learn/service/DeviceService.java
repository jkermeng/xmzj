package com.learn.service;

import com.learn.entity.Device;

import java.util.List;
import java.util.Map;

public interface DeviceService {
    /**
     * 查询
     * @return
     */
    Device queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<Device> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(Device project);

    /**
     * 修改
     * @return
     */
    void update(Device project);

    /**
     * 删除
     * @return
     */
    void delete(Long id);

    /**
     * 批量删除
     * @return
     */
    void deleteBatch(Long[] ids);
}
