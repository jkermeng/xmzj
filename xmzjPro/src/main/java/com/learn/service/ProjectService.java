package com.learn.service;

import com.learn.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目
 * 
 
 * 
 */
public interface ProjectService {
    /**
    * 查询
	* @return
	*/
	ProjectEntity queryObject(Long id);

    /**
    * 查询列表
    * @return
    */
	List<ProjectEntity> queryList(Map<String, Object> map);

    /**
    * 查询总数
    * @return
    */
	int queryTotal(Map<String, Object> map);

    /**
    * 保存
    * @return
    */
	void save(ProjectEntity project);

    /**
    * 修改
    * @return
    */
	void update(ProjectEntity project);

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
