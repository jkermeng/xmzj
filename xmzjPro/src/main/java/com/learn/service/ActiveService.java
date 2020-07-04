package com.learn.service;

import com.learn.entity.Active;

import java.util.List;
import java.util.Map;

public interface ActiveService {
    /**
     * 查询
     * @return
     */
    Active queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<Active> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(Active project);

    /**
     * 修改
     * @return
     */
    void update(Active project);

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
