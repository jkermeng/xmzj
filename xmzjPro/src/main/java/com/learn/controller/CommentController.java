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

import com.learn.entity.CommentEntity;
import com.learn.service.CommentService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 指导信息
 * 
 * 
 * 
 */
@RestController
@RequestMapping("comment")
public class CommentController extends AbstractController {
	@Autowired
	private CommentService commentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		if (super.getUserId() > 1 && "3".equals(super.getUser().getType1()))
			params.put("user", super.getUserId());
		if (super.getUserId() > 1 && "1".equals(super.getUser().getType1()))
			params.put("pro", super.getUserId());
															

		//查询列表数据
        Query query = new Query(params);

		List<CommentEntity> commentList = commentService.queryList(query);
		int total = commentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(commentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 列表
	 */
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
		List<CommentEntity> commentList = commentService.queryList(query);
		return R.ok().put("list", commentList );
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CommentEntity comment = commentService.queryObject(id);
		
		return R.ok().put("comment", comment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CommentEntity comment){


        commentService.save(comment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CommentEntity comment){
		commentService.update(comment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] ids){
		commentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
