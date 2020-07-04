package com.learn.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.TypeEntity;
import com.learn.service.TypeService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 擅长领域
 * 
 * 
 * 
 */
@RestController
@RequestMapping("type")
public class TypeController extends AbstractController {
	@Autowired
	private TypeService typeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

												

		//查询列表数据
        Query query = new Query(params);

		List<TypeEntity> typeList = typeService.queryList(query);
		int total = typeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(typeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<TypeEntity> typeList = typeService.queryList(query);
		return R.ok().put("list", typeList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		TypeEntity type = typeService.queryObject(id);
		
		return R.ok().put("type", type);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TypeEntity type){

												

        typeService.save(type);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TypeEntity type){
		typeService.update(type);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		typeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
