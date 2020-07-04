package com.learn.controller;

import com.learn.entity.Stuff;
import com.learn.entity.U_Details;
import com.learn.service.StuffService;
import com.learn.service.U_DetailsService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("stuff")
public class StuffController extends AbstractController{
    @Autowired
    private StuffService stuffService;

    @RequestMapping("showAll")
    public R showAll(@RequestParam Map<String, Object> params) {
        System.out.println("用户的id"+getUserId());
        System.out.println("用户的id"+getUser());
        Query query = new Query(params);
        List<Stuff> stuffs = stuffService.queryList(query);
        int total = stuffService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(stuffs, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("page")
    public R page(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Stuff> stuffs = stuffService.queryList(query);
        int total = stuffService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(stuffs, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("detail")
    public R showDetail(long id) {
        Stuff stuff = stuffService.queryObject(id);
        return R.ok().put("detail", stuff);
    }

    @RequestMapping("add")
    public R addStuff(Stuff stuff) {
        stuffService.save(stuff);
        return R.ok();
    }

    @RequestMapping("update")
    public R update(Stuff stuff) {
        stuffService.update(stuff);
        return R.ok();
    }

    @RequestMapping("del")
    public R delete(@RequestBody Long ids[]) {
        for (long id : ids
        ) {
            System.out.println("delete id have :" + id);
        }
        stuffService.deleteBatch(ids);
        return R.ok();
    }

}
