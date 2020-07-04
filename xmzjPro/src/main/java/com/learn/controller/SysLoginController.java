package com.learn.controller;

import com.learn.entity.SysUserEntity;
import com.learn.entity.U_Details;
import com.learn.service.SysUserService;
import com.learn.service.U_DetailsService;
import com.learn.utils.MultipartFileUtil;
import com.learn.utils.R;
import com.learn.utils.ShiroUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.web.multipart.MultipartFile;

/**
 * 登录相关
 * <p>
 * <p>
 * <p>
 * 10#1:15:31
 */
@Controller
public class SysLoginController {
    public static final Logger logger = LoggerFactory.getLogger(SysLoginController.class);

    @Autowired
    private Producer producer;
    @Autowired
    private U_DetailsService u_detailsService;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();

        logger.info(text);
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public R login(String username, String password, String captcha) throws IOException {
//

        logger.info("验证码：" + captcha);
        try {
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(e.getMessage());
        } catch (LockedAccountException e) {
            return R.error(e.getMessage());
        } catch (AuthenticationException e) {
            return R.error("账户验证失败");
        }

        return R.ok();
    }


    /**
     *
     */
    @ResponseBody
    @RequestMapping(value = "/sys/reg", method = RequestMethod.POST)
    public R reg(String username, String password, Long roleId, MultipartFile file, HttpServletRequest request) throws IOException {
        //sha256加密
        SysUserEntity user = new SysUserEntity();
        user.setUsername(username);
        user.setPassword(password);
        if (roleId==3){
            user.setStatus(1);
        }else if (roleId==4){
            user.setStatus(2);
        }
            user.setType1(roleId + "");
            List<Long> roles = new ArrayList<>();
            roles.add(roleId);
            user.setRoleIdList(roles);
            this.sysUserService.save(user);
            if (null == file || file.isEmpty()) {
                //为空
            } else {
                //不空
                logger.info("文件名称" + file.getOriginalFilename());
                //存储到详细信息中
                String fileName = MultipartFileUtil.uploadFile("statics/img", file, request);
                U_Details uDetails = new U_Details();
                uDetails.setUd_imgurl(fileName);
                uDetails.setSysu_id(user.getUserId().intValue());
                uDetails.setUd_status(1);
                u_detailsService.save(uDetails);
            }

        return R.ok();
    }



    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        ShiroUtils.logout();
        return "redirect:login.html";
    }
    @RequestMapping(value = "goreg", method = RequestMethod.GET)
    public String goreg() {
        ShiroUtils.logout();
        return "redirect:reg.html";
    }
}
