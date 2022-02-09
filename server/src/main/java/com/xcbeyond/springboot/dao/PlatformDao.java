package com.xcbeyond.springboot.dao;

import com.xcbeyond.springboot.model.Platform;

public interface PlatformDao {

    /**
     * 添加平台
     * @param platform
     */
    int insertPlatform(Platform platform);
}
