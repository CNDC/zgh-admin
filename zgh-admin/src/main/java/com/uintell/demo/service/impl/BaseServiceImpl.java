package com.uintell.demo.service.impl;

import com.uintell.demo.dao.impl.BaseDaoImpl;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 服务基类
 */
public class BaseServiceImpl {
    private BaseDaoImpl baseDao;
   // private ICacheService redisCacheService;

    public BaseDaoImpl getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDaoImpl baseDao) {
        this.baseDao = baseDao;
    }

   /* public ICacheService getRedisCacheService() {
        return redisCacheService;
    }

    public void setRedisCacheService(ICacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }
*/
}
