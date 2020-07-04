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

import com.learn.entity.TestEntity;
import com.learn.service.TestService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * test
 * 
 * 
 * 
 */
@RestController
@RequestMapping("test")
public class TestController extends AbstractController {
	@Autowired
	private TestService testService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){

																																					

		//查询列表数据
        Query query = new Query(params);

		List<TestEntity> testList = testService.queryList(query);
		int total = testService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(testList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<TestEntity> testList = testService.queryList(query);
		return R.ok().put("list", testList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		TestEntity test = testService.queryObject(id);
		
		return R.ok().put("test", test);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody TestEntity test){

																																					

        testService.save(test);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody TestEntity test){
		testService.update(test);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		testService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
