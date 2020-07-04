package com.learn.service;

import com.learn.entity.Device;
import com.learn.entity.JoinActive;

import java.util.List;
import java.util.Map;

public interface JoinActiveService {
    /**
     * 查询
     * @return
     */
    JoinActive queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<JoinActive> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(JoinActive project);

    /**
     * 修改
     * @return
     */
    void update(JoinActive project);

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
