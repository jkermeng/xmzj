package com.learn.service;

import com.learn.entity.Stuff;
import com.learn.entity.Stuff;

import java.util.List;
import java.util.Map;

public interface StuffService {
    /**
     * 查询
     * @return
     */
    Stuff queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<Stuff> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(Stuff project);

    /**
     * 修改
     * @return
     */
    void update(Stuff project);

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
