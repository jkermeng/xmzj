package com.learn.controller;

import com.learn.dao.ProjectDao;
import com.learn.dao.StuffDao;
import com.learn.entity.ProjectEntity;
import com.learn.entity.Stuff;
import com.learn.entity.SysUserEntity;
import com.learn.service.ProjectService;
import com.learn.service.StuffService;
import com.learn.service.SysUserService;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("mytest")
public class MyTestController extends AbstractController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StuffService stuffService;
    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public R test() {
        ProjectEntity projectEntity = projectService.queryObject((long) 2);
        Stuff stuff = stuffService.queryObject((long) 2);
        List<Stuff> stuffs = stuffService.queryList(null);
        return R.ok().put("all", stuffs);
    }
}
