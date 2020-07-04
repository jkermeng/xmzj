package com.learn.service;

import com.learn.entity.TestEntity;

import java.util.List;
import java.util.Map;

/**
 * test
 * 
 
 * 
 */
public interface TestService {
    /**
    * 查询
	* @return
	*/
	TestEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<TestEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(TestEntity test);

    /**
    * 修改
    * @return
    */
	void update(TestEntity test);

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
