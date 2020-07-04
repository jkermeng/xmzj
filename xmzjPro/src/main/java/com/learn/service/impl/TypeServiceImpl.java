package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

		

import com.learn.dao.TypeDao;
import com.learn.entity.TypeEntity;
import com.learn.service.TypeService;
import com.learn.service.*;



@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;

			

			

	

	
	@Override
	public TypeEntity queryObject(Long id){
			TypeEntity entity = typeDao.queryObject(id);

							
		return entity;
	}
	
	@Override
	public List<TypeEntity> queryList(Map<String, Object> map){
        List<TypeEntity> list = typeDao.queryList(map);
        for(TypeEntity entity : list){
																			}
		return list;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return typeDao.queryTotal(map);
	}
	
	@Override
	public void save(TypeEntity type){
		typeDao.save(type);
	}
	
	@Override
	public void update(TypeEntity type){
		typeDao.update(type);
	}
	
	@Override
	public void delete(Long id){
		typeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		typeDao.deleteBatch(ids);
	}
	
}
