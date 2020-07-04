package com.learn.service;

import java.util.List;



/**
 * 用户与角色对应关系
 * 
 *
 *
 * @date 18#9:43:24
 */
public interface SysUserRoleService {
	
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
	
	void delete(Long userId);
}
