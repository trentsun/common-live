package com.xcbeyond.springboot.dao.impl;

import com.xcbeyond.springboot.dao.RoomDao;
import com.xcbeyond.springboot.dao.UserDao;
import com.xcbeyond.springboot.model.Room;
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
public class RoomDaoJdbcTemplateImpl implements RoomDao {
	
	//自动导入依赖的bean
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public int insertUser(Room room) {
		String sql = "INSERT INTO live_room (room_id, platform, isReplay, name , live_url) VALUES (:room_id, :platform, :isReplay, :name, :live_url)";
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("room_id", room.id);
		param.put("platform", room.platform);
		param.put("isReplay", room.isReplay);
		param.put("name", room.name);
		param.put("live_url", room.live_url);
		
		return jdbcTemplate.update(sql, param);
	}

}
