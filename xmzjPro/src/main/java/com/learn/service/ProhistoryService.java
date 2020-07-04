package com.learn.service;

import com.learn.entity.Prohistory;

import java.util.List;
import java.util.Map;

public interface ProhistoryService {
    /**
     * 查询
     * @return
     */
    Prohistory queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<Prohistory> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(Prohistory project);

    /**
     * 修改
     * @return
     */
    void update(Prohistory project);

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
