package com.xcbeyond.springboot.service.impl;

import com.xcbeyond.springboot.dao.PlatformDao;
import com.xcbeyond.springboot.mapper.PlatformMapper;
import com.xcbeyond.springboot.model.Platform;
import com.xcbeyond.springboot.service.PlatformService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
//指定使用缓存名
@CacheConfig(cacheNames = "platformCache")
public class PlatformServiceImpl implements PlatformService {

    @Resource
    private PlatformDao platformDao;

    @Resource
    private PlatformMapper platformMapper;


    @Override
    public int insertPlatformByJdbcTemplate(Platform platform) {
        return platformDao.insertPlatform(platform);
    }

    @Override
    public List<Platform> getPlatforms() {
        return platformMapper.getPlatforms();
    }

    @Override
    //@Cacheable:将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key
//    @Cacheable(key="#p0")
    public Platform queryPlatformByPlatformId(String platformId) {
        return platformMapper.queryPlatformByPlatformId(platformId);
    }

    @Override
    //@Cacheable:将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key
//    @Cacheable(key="#p0")
    public void updateByPlatformId(String platformId, String platformName) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", platformId);
        map.put("name", platformName);
        platformMapper.updateByPlatformId(map);
    }
}
