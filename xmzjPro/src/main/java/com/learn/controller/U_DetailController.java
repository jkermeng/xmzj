package com.learn.controller;


import com.learn.dao.SysUserRoleDao;
import com.learn.entity.SysRoleEntity;
import com.learn.entity.SysUserEntity;
import com.learn.entity.SysUserRoleEntity;
import com.learn.entity.U_Details;
import com.learn.service.SysRoleService;
import com.learn.service.SysUserRoleService;
import com.learn.service.SysUserService;
import com.learn.service.U_DetailsService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("udetail")
public class U_DetailController {
    @Autowired
    private U_DetailsService u_detailsService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("showAll")
    public R showAll(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<U_Details> u_details = u_detailsService.queryList(query);
        int total = u_detailsService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(u_details, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("page")
    public R page(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<U_Details> u_details = u_detailsService.queryList(query);
        int total = u_detailsService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(u_details, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("detail")
    public R showDetail(long id) {
        HashMap<String, Object> ids = new HashMap<>();
        ids.put("sysu_id", id);
        List<U_Details> u_details = u_detailsService.queryList(ids);
        U_Details uDetails = null;
        if (u_details.size() > 0) {
            uDetails = u_details.get(0);
        }
        return R.ok().put("detail", uDetails);
    }

    @RequestMapping("add")
    public R addU_Detail(U_Details U_Detail) {
        U_Detail.setUd_status(1);
        u_detailsService.save(U_Detail);
        return R.ok();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public R update(@RequestBody U_Details U_Detail) {
        u_detailsService.update(U_Detail);
        return R.ok();
    }

    @RequestMapping("del")
    public R delete(@RequestBody Long ids[]) {
        for (long id : ids
        ) {
            System.out.println("delete id have :" + id);
        }
        u_detailsService.deleteBatch(ids);
        return R.ok();
    }

    @Autowired
    private SysRoleService roleService;

    @RequestMapping("getRole")
    public R getRole() {
        HashMap<String, Object> roles = new HashMap<>();
        List<SysRoleEntity> sysRoleEntities = roleService.queryList(roles);
        for (int i=0;i<sysRoleEntities.size();i++
        ) {
            if (sysRoleEntities.get(i).getRoleId() == 2) {
                sysRoleEntities.remove(sysRoleEntities.get(i));

            }
        }
        return R.ok().put("role", sysRoleEntities);
    }

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @RequestMapping("updateRole")
    public R changeRole(SysUserRoleEntity sysRoleEntity) {
        if (null == sysRoleEntity.getId()) {
            sysUserRoleDao.mysave(sysRoleEntity);
        }else {
            sysUserRoleDao.update(sysRoleEntity);
        }
        return R.ok();
    }

}
