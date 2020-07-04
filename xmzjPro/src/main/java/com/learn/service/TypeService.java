package com.learn.service;

import com.learn.entity.TypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 擅长领域
 * 
 
 * 
 */
public interface TypeService {
    /**
    * 查询
	* @return
	*/
	TypeEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<TypeEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(TypeEntity type);

    /**
    * 修改
    * @return
    */
	void update(TypeEntity type);

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
