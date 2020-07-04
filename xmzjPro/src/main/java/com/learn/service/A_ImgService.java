package com.learn.service;

import com.learn.entity.A_Img;

import java.util.List;
import java.util.Map;

public interface A_ImgService {
    /**
     * 查询
     * @return
     */
    A_Img queryObject(Long id);

    /**
     * 查询列表
     * @return
     */
    List<A_Img> queryList(Map<String, Object> map);

    /**
     * 查询总数
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存
     * @return
     */
    void save(A_Img project);

    /**
     * 修改
     * @return
     */
    void update(A_Img project);

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
