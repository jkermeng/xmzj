package com.learn.controller;

import com.learn.dao.SysUserDao;
import com.learn.entity.*;
import com.learn.service.*;
import com.learn.utils.MultipartFileUtil;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("active")
public class ActiveController {
    @Autowired
    private ActiveService activeService;
    @Autowired
    private A_ImgService a_imgService;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private U_DetailsService u_detailsService;

    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {

        //查询列表数据
        Query query = new Query(params);
        List<SysUserEntity> userList = sysUserDao.queryList(query);
        int total = sysUserDao.queryTotal(query);
        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("details")
    public R showDetails(Long userId) {
        System.out.println(userId);
        SysUserEntity user = sysUserDao.queryObject(userId);
        HashMap<String, Object> users = new HashMap<>();
        users.put("sysu_id", user.getUserId());
        List<U_Details> u_details = u_detailsService.queryList(users);
        if (u_details.size() > 0) {
            u_details.get(0).setUserEntity(null);
            user.setU_details(u_details.get(0));
        }
        return R.ok().put("detail", user);
    }

    @RequestMapping("showAll")
    public R showAll(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Active> actives = activeService.queryList(query);
        int total = activeService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(actives, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("showAll2")
    public R showAll2(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Active> actives = activeService.queryList(query);
        for (Active ac : actives
        ) {
            Map<String, Object> imgs = new HashMap<>();
            imgs.put("ai_aid", ac.getA_id());
            List<A_Img> a_imgs = a_imgService.queryList(imgs);
            if (a_imgs.size() > 0) {
                ac.setA_imgList(a_imgs);
            }
        }
        int total = activeService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(actives, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("detail")
    public R showDetail(long id) {
        Active active = activeService.queryObject(id);
        Map<String, Object> imgs = new HashMap<>();
        imgs.put("ai_aid", active.getA_id());
        List<A_Img> a_imgs = a_imgService.queryList(imgs);
        if (a_imgs.size() > 0) {
            active.setA_imgList(a_imgs);
        }
        Map<String, Object> pers = new HashMap<>();
        pers.put("a_id", id);
        int total = joinActiveService.queryTotal(pers);
        active.setLastNum(active.getA_pnum()-total);
        return R.ok().put("detail", active);
    }

    @RequestMapping("page")
    public R page(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Active> actives = activeService.queryList(query);
        int total = activeService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(actives, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("add")
    public R addActive(Active Active, HttpServletRequest request, MultipartFile file[]) {
        activeService.save(Active);
        if (null != file && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                String s = MultipartFileUtil.uploadFile("statics/img", file[i], request);
                System.out.println("上传后出来的地址" + s);
                A_Img a_img = new A_Img();
                a_img.setAi_aid(Active.getA_id());
                a_img.setAi_url(s);
                a_imgService.save(a_img);
            }
        }
        return R.ok();
    }

    @RequestMapping("update")
    public R update(Active Active) {
        activeService.update(Active);
        return R.ok();
    }

    @RequestMapping("del")
    public R delete(@RequestBody Long ids[]) {
        for (long id : ids
        ) {
            Map<String, Object> imgs = new HashMap<>();
            imgs.put("ai_aid", id);
            List<A_Img> a_imgs = a_imgService.queryList(imgs);
            if (a_imgs.size() > 0) {
                Long aid[] = new Long[a_imgs.size()];
                for (int i = 0; i < a_imgs.size(); i++) {
                    aid[i] = (long) a_imgs.get(i).getAi_id();
                }
                a_imgService.deleteBatch(aid);
            }
        }
        activeService.deleteBatch(ids);
        return R.ok();
    }

    @Autowired
    private JoinActiveService joinActiveService;

    @RequestMapping("join")
    public R activeJoin(JoinActive active) {
        if (null != active && null != active.getA_id()) {
            Active active1 = activeService.queryObject((long) active.getA_id());
            HashMap<String, Object> joinmap = new HashMap<>();
            joinmap.put("a_id", active.getA_id());
            List<JoinActive> joinActives = joinActiveService.queryList(joinmap);
            if (joinActives.size() < active1.getA_pnum()) {
                boolean flag = true;
                for (JoinActive joa : joinActives
                ) {
                    if (active.getUid() == joa.getUid()) {
                        flag = false;
                    }
                }
                if (flag) {
                    joinActiveService.save(active);
                    return R.ok("加入成功");
                } else {
                    return R.error("不能重复加入同一个活动");
                }
            } else {
                return R.error("超出参加人数,不允许加入");
            }
        } else {
            return R.error("空值传入错误");
        }


    }
}
