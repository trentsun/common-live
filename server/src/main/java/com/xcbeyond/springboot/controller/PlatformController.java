package com.xcbeyond.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xcbeyond.springboot.model.BaseResponse;
import com.xcbeyond.springboot.model.Platform;
import com.xcbeyond.springboot.service.PlatformService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Controller demo
 * @author xcbeyond
 * 2018年7月5日下午11:22:49
 */

//是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值直接填入HTTP响应体中,是REST风格的控制器。
@RestController
//提供路由信息，负责URL到Controller中的具体函数的映射
@RequestMapping("/platform")
public class PlatformController {
	@Resource
	private PlatformService platformService;
	
	/**
	 * 通过JdbcTemplate方式插入用户信息
	 * @return
	 */
	@RequestMapping("/insert")
	public String insertPlatformByJdbcTemplate(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("icon_url") String icon_url) {
		Platform platform = new Platform();
		platform.setId(id);
		platform.setName(name);
		platform.setIcon_url(icon_url);
		int result = platformService.insertPlatformByJdbcTemplate(platform);
		return String.valueOf(result);
		
	}

	@RequestMapping(value = "/getPlatforms", method=RequestMethod.GET)
	public String getPlatforms() {
		List<Platform> platformList = platformService.getPlatforms();
		BaseResponse<List<Platform>> response = new BaseResponse<>();
		response.data = platformList;
		return JSON.toJSONString(response);
	}
	
	/**
	 * 通过platformid查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/queryPlatformByPlatformId", method=RequestMethod.GET)
	public String queryPlatformByPlatformId(@RequestParam("id") String id) {
		Platform platform = platformService.queryPlatformByPlatformId(id);
		return platform.toString();
		
	}
	
	/**
	 * 通过platformid更新platformname
	 * @param id
	 * @param name
	 */
	@RequestMapping(value="/updateByPlatformId", method=RequestMethod.GET)
	public String updateByPlatformId(@RequestParam("id") String id, @RequestParam("name") String name) {
		platformService.updateByPlatformId(id, name);
		return id + "更新platform name成功!";
	}
}
