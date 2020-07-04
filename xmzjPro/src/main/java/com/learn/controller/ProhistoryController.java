package com.learn.controller;

import com.learn.entity.Collect;
import com.learn.entity.Device;
import com.learn.entity.Prohistory;
import com.learn.entity.SysUserEntity;
import com.learn.service.CollectService;
import com.learn.service.ProhistoryService;
import com.learn.service.SysUserService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("prohis")
public class ProhistoryController {
    @Autowired
    private ProhistoryService prohistoryService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("showAllcol")
    public R showAllcol(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Collect> collects = null;
        collects = collectService.queryList(query);
        HashSet<Collect> objects = new HashSet<>();
        objects.addAll(collects);
        collects.addAll(objects);
        for (Collect collect : collects
        ) {
            SysUserEntity sysUserEntity = sysUserService.mqueryObject((long) collect.getC_stuffid());
            collect.setSysUserEntity(sysUserEntity);
        }
        int total = collects.size();
        PageUtils pageUtil = new PageUtils(collects, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("showAllpro")
    public R showAllpro(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Prohistory> prohistories = null;
        prohistories = prohistoryService.queryList(query);
        HashSet<Prohistory> objects = new HashSet<>();
        objects.addAll(prohistories);
        prohistories.addAll(objects);
        for (Prohistory collect : prohistories
        ) {
            SysUserEntity sysUserEntity = sysUserService.mqueryObject((long) collect.getPhuid());
            collect.setSysUserEntity(sysUserEntity);
        }
        int total = prohistoryService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(prohistories, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("addcol")
    public R addcol(Collect Prohistory) {
        collectService.save(Prohistory);
        return R.ok();
    }

    @RequestMapping("addpro")
    public R addpro(Prohistory Prohistory) {
        prohistoryService.save(Prohistory);
        return R.ok();
    }

    @RequestMapping("delcol")
    public R delcol(@RequestBody Long ids[]) {
        for (long id : ids
        ) {
            System.out.println("delete id have :" + id);
        }
        collectService.deleteBatch(ids);
        return R.ok();
    }

    @RequestMapping("delpro")
    public R delpro(@RequestBody Long ids[]) {
        for (long id : ids
        ) {
            System.out.println("delete id have :" + id);
        }
        prohistoryService.deleteBatch(ids);
        return R.ok();
    }
}
