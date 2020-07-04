package com.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 * 
 *
 *
 * 24#11:05:27
 */
@Controller
public class SysPageController {
	public static final Logger logger = LoggerFactory.getLogger(SysPageController.class);

	@RequestMapping("sys/{url}.html")
	public String page(@PathVariable("url") String url){
		logger.info("holle fucker");
		return "sys/" + url + ".html";
	}

	@RequestMapping("admin/{url}.html")
	public String generator(@PathVariable("url") String url){
		logger.info("holle fucker....");
		return "admin/" + url + ".html";
	}
}
