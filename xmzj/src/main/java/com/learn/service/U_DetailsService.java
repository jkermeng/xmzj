package com.learn.service;

import com.learn.entity.U_Details;

import java.util.List;
import java.util.Map;

public interface U_DetailsService {
    /**
     * 查询
     * @return
     */
    U_Details queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<U_Details> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(U_Details test);

    /**
     * 修改
     * @return
     */
    void update(U_Details test);

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
