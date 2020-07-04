package com.learn.service.impl;

import com.learn.dao.StuffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.learn.service.SysUserService;


import com.learn.dao.ProjectDao;
import com.learn.entity.ProjectEntity;
import com.learn.service.ProjectService;
import com.learn.service.*;


@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private StuffDao stuffDao;

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private TypeService typeService;


    @Autowired
    private SysUserService proService;


    @Override
    public ProjectEntity queryObject(Long id) {
        ProjectEntity entity = projectDao.queryObject(id);

        if (this.sysUserService.queryObject(entity.getUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));


        if (entity.getType() != null && this.typeService.queryObject(entity.getType()) != null)
            entity.setTypeEntity(this.typeService.queryObject(entity.getType()));


        if (entity.getPro() != null && this.proService.queryObject(entity.getPro()) != null)
            entity.setProEntity(this.proService.queryObject(entity.getPro()));


        return entity;
    }

    @Override
    public List<ProjectEntity> queryList(Map<String, Object> map) {
        List<ProjectEntity> list = projectDao.queryList(map);
        for (ProjectEntity entity : list) {
            if (this.sysUserService.queryObject(entity.getUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));


            if (entity.getType() != null && this.typeService.queryObject(entity.getType()) != null)
                entity.setTypeEntity(this.typeService.queryObject(entity.getType()));


            if (entity.getPro() != null && this.proService.queryObject(entity.getPro()) != null)
                entity.setProEntity(this.proService.queryObject(entity.getPro()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return projectDao.queryTotal(map);
    }

    @Override
    public void save(ProjectEntity project) {
        projectDao.save(project);
    }

    @Override
    public void update(ProjectEntity project) {
        projectDao.update(project);
    }

    @Override
    public void delete(Long id) {
        projectDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        projectDao.deleteBatch(ids);
    }

}
