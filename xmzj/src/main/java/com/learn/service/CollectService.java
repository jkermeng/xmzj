package com.learn.service;

import com.learn.entity.Collect;

import java.util.List;
import java.util.Map;

public interface CollectService {
    /**
     * 查询
     * @return
     */
    Collect queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<Collect> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(Collect project);

    /**
     * 修改
     * @return
     */
    void update(Collect project);

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
