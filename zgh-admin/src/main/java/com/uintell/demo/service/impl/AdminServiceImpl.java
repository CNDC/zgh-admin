package com.uintell.demo.service.impl;

import com.uintell.demo.exception.ServiceException;
import com.uintell.demo.service.AdminService;
import com.uintell.demo.bean.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2018/1/3 16:59
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl implements AdminService {
    @Override
    public List<Admin> selectByMap(Map<String, Object> map) {
        //验证参数
        if (checkParam(map)) {
            return null;
        }
        List<Admin> list = getBaseDao().queryForList("adminMapper.selectAdminByUsernameAndPassword", map, Admin.class);
        return list;
    }

    @Override
    public void updateById(Admin admin) {
        getBaseDao().insert("", admin);
    }

    private boolean checkParam(Map<String, Object> map) {
        if (null == map) {
            return true;
        }
        if ("".equals(map.get("username")) && map.get("username") == null) {
            return true;
        }
        if ("".equals(map.get("password")) && map.get("password") == null) {
            return true;
        }
        return false;
    }
}
