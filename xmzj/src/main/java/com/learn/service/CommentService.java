package com.learn.service;

import com.learn.entity.CommentEntity;

import java.util.List;
import java.util.Map;

/**
 * 指导信息
 * 
 
 * 
 */
public interface CommentService {
    /**
    * 查询
	* @return
	*/
	CommentEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<CommentEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(CommentEntity comment);

    /**
    * 修改
    * @return
    */
	void update(CommentEntity comment);

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
