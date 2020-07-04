package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * 指导信息
 *
 
 *  
 */
public class CommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //项目
                    private Long project;

            private  ProjectEntity  projectEntity;

            public ProjectEntity getProjectEntity() {
                return projectEntity;
            }

            public void setProjectEntity(ProjectEntity projectEntity) {
                this.projectEntity = projectEntity;
            }
        
            //内容
                    private String content;
        
            //所属人
                    private Long user;

            private SysUserEntity sysUserEntity;

            public SysUserEntity getSysUserEntity() {
                return sysUserEntity;
            }

            public void setSysUserEntity(SysUserEntity sysUserEntity) {
                this.sysUserEntity = sysUserEntity;
            }

        
            //所属专家
                    private Long pro;

            private  SysUserEntity  proEntity;

            public SysUserEntity getProEntity() {
                return proEntity;
            }

            public void setProEntity(SysUserEntity proEntity) {
                this.proEntity = proEntity;
            }
        
            //添加时间
                    private Date gmttime =new  Date();
        
    
            /**
         * 设置：
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * 获取：
         */
        public Long getId() {
            return id;
        }
            /**
         * 设置：项目
         */
        public void setProject(Long project) {
            this.project = project;
        }

        /**
         * 获取：项目
         */
        public Long getProject() {
            return project;
        }
            /**
         * 设置：内容
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：内容
         */
        public String getContent() {
            return content;
        }
            /**
         * 设置：所属人
         */
        public void setUser(Long user) {
            this.user = user;
        }

        /**
         * 获取：所属人
         */
        public Long getUser() {
            return user;
        }
            /**
         * 设置：所属专家
         */
        public void setPro(Long pro) {
            this.pro = pro;
        }

        /**
         * 获取：所属专家
         */
        public Long getPro() {
            return pro;
        }
            /**
         * 设置：添加时间
         */
        public void setGmttime(Date gmttime) {
            this.gmttime = gmttime;
        }

        /**
         * 获取：添加时间
         */
        public Date getGmttime() {
            return gmttime;
        }
    }
