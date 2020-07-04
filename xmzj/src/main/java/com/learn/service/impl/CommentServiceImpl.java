package com.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.learn.service.SysUserService;


import com.learn.dao.CommentDao;
import com.learn.entity.CommentEntity;
import com.learn.service.CommentService;
import com.learn.service.*;


@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;


    @Autowired
    private ProjectService projectService;


    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private SysUserService proService;


    @Override
    public CommentEntity queryObject(Long id) {
        CommentEntity entity = commentDao.queryObject(id);


        if (entity.getProject() != null && this.projectService.queryObject(entity.getProject()) != null)
            entity.setProjectEntity(this.projectService.queryObject(entity.getProject()));

        if (this.sysUserService.queryObject(entity.getUser()) != null)
            entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));


        if (entity.getPro() != null && this.proService.queryObject(entity.getPro()) != null)
            entity.setProEntity(this.proService.queryObject(entity.getPro()));


        return entity;
    }

    @Override
    public List<CommentEntity> queryList(Map<String, Object> map) {
        List<CommentEntity> list = commentDao.queryList(map);
        for (CommentEntity entity : list) {

            if (entity.getProject() != null && this.projectService.queryObject(entity.getProject()) != null)
                entity.setProjectEntity(this.projectService.queryObject(entity.getProject()));

            if (this.sysUserService.queryObject(entity.getUser()) != null)
                entity.setSysUserEntity(this.sysUserService.queryObject(entity.getUser()));


            if (entity.getPro() != null && this.proService.queryObject(entity.getPro()) != null)
                entity.setProEntity(this.proService.queryObject(entity.getPro()));

        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return commentDao.queryTotal(map);
    }

    @Override
    public void save(CommentEntity comment) {
        commentDao.save(comment);
    }

    @Override
    public void update(CommentEntity comment) {
        commentDao.update(comment);
    }

    @Override
    public void delete(Long id) {
        commentDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        commentDao.deleteBatch(ids);
    }

}
