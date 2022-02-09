package com.xcbeyond.springboot.service;

import com.xcbeyond.springboot.model.Platform;

public interface PlatformService {

    /**
     * 通过JdbcTemplate方式插入平台信息
     * @return
     */
    public int insertPlatformByJdbcTemplate(Platform platform);

    /**
     *  通过id查询
     * @param platformId
     * @return
     */
    public Platform queryPlatformByPlatformId(String platformId);

    /**
     * 通过id更新Platformname
     * @param platformId
     * @param platformName
     */
    public void updateByPlatformId(String platformId, String platformName);
}
