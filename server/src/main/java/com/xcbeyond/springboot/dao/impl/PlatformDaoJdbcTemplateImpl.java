package com.xcbeyond.springboot.dao.impl;

import com.xcbeyond.springboot.dao.PlatformDao;
import com.xcbeyond.springboot.dao.UserDao;
import com.xcbeyond.springboot.model.Platform;
import com.xcbeyond.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * JdbcTemplate方式完成对t_user表的操作
 * @author xcbeyond
 * 2018年7月12日上午11:53:44
 */
//作用于持久层.用来表明该类是用来执行与数据库相关的操作（即dao对象），并支持自动处理数据库操作产生的异常
@Repository
public class PlatformDaoJdbcTemplateImpl implements PlatformDao {
	
	//自动导入依赖的bean
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public int insertPlatform(Platform platform) {
		String sql = "INSERT INTO platform (id, name, icon_url) VALUES (:id, :name, :icon_url)";
		Map<String,Object> param = new HashMap<>();
		param.put("id", platform.getId());
		param.put("name", platform.getName());
		param.put("icon_url", platform.getIcon_url());

		return jdbcTemplate.update(sql, param);
	}

}
