package com.learn.controller;

import com.learn.entity.Device;
import com.learn.entity.Device;
import com.learn.service.DeviceService;
import com.learn.utils.PageUtils;
import com.learn.utils.Query;
import com.learn.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @RequestMapping("showAll")
    public R showAll(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Device> devices = deviceService.queryList(query);
        int total = deviceService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(devices, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }

    @RequestMapping("page")
    public R page(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Device> devices = deviceService.queryList(query);
        int total = deviceService.queryTotal(params);
        PageUtils pageUtil = new PageUtils(devices, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }


    @RequestMapping("detail")
    public R showDetail(long id) {
        Device device = deviceService.queryObject(id);
        return R.ok().put("detail", device);
    }

    @RequestMapping("add")
    public R addDevice(Device Device) {
        deviceService.save(Device);
        return R.ok();
    }

    @RequestMapping("update")
    public R update(Device Device) {
        deviceService.update(Device);
        return R.ok();
    }

    @RequestMapping("del")
    public R delete(@RequestBody Long ids[]) {
        for (long id : ids
        ) {
            System.out.println("delete id have :" + id);
        }
        deviceService.deleteBatch(ids);
        return R.ok();
    }
}
