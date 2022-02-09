package com.xcbeyond.springboot.mapper;

import com.xcbeyond.springboot.model.Platform;

import java.util.HashMap;
import java.util.List;

public interface PlatformMapper {
    public List<Platform> getPlatforms();
    /**
     * 通过platformid查询
     * @param platformId
     * @return
     */
    public Platform queryPlatformByPlatformId(String platformId);

    /**
     * 通过platformid更新platformname
     * @param platformId
     * @param platformName
     */
    public void updateByPlatformId(HashMap<String,String> map);
}
