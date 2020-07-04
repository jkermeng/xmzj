package com.learn.entity;

        import java.io.Serializable;
        import java.util.Date;
        import com.learn.service.*;



/**
 * test
 *
 
 *  
 */
public class TestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

            //
                    private Long id;
        
            //头像
                    private String img;
        
            //性别
                    private String sex;
        
            //擅长领域
                    private Long type;

            private  TypeEntity  typeEntity;

            public TypeEntity getTypeEntity() {
                return typeEntity;
            }

            public void setTypeEntity(TypeEntity typeEntity) {
                this.typeEntity = typeEntity;
            }
        
            //个人介绍
                    private String content;
        
            //添加时间
                    private Date gmttime =new  Date();
        
            //指导价格
                    private Double price;
        
    
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
         * 设置：头像
         */
        public void setImg(String img) {
            this.img = img;
        }

        /**
         * 获取：头像
         */
        public String getImg() {
            return img;
        }
            /**
         * 设置：性别
         */
        public void setSex(String sex) {
            this.sex = sex;
        }

        /**
         * 获取：性别
         */
        public String getSex() {
            return sex;
        }
            /**
         * 设置：擅长领域
         */
        public void setType(Long type) {
            this.type = type;
        }

        /**
         * 获取：擅长领域
         */
        public Long getType() {
            return type;
        }
            /**
         * 设置：个人介绍
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         * 获取：个人介绍
         */
        public String getContent() {
            return content;
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
            /**
         * 设置：指导价格
         */
        public void setPrice(Double price) {
            this.price = price;
        }

        /**
         * 获取：指导价格
         */
        public Double getPrice() {
            return price;
        }
    }
