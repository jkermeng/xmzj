package com.learn.controller;

import java.util.List;
import java.util.Map;

import com.learn.service.StuffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.ProjectEntity;
import com.learn.service.ProjectService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;


/**
 * 项目
 */
@RestController
@RequestMapping("project")
public class ProjectController extends AbstractController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StuffService stuffService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        if (super.getUserId() > 1 && "3".equals(super.getUser().getType1()))
            params.put("user", super.getUserId());
        if (super.getUserId() > 1 && "1".equals(super.getUser().getType1()))
            params.put("pro", super.getUserId());
        //查询列表数据
        Query query = new Query(params);
        List<ProjectEntity> projectList = projectService.queryList(query);
        int total = projectService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(projectList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }


    /**
     * 列表
     */
    @RequestMapping("/list2")
    public R list2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ProjectEntity> projectList = projectService.queryList(query);
        return R.ok().put("list", projectList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ProjectEntity project = projectService.queryObject(id);
        return R.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProjectEntity project) {

        if (project.getUser() == null)
            project.setUser(super.getUserId());


        projectService.save(project);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProjectEntity project) {
        projectService.update(project);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        projectService.deleteBatch(ids);

        return R.ok();
    }

}
