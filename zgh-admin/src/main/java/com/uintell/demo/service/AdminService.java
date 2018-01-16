package com.uintell.demo.service;

import com.uintell.demo.bean.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2018/1/3 16:59
 */
public interface AdminService {

    List<Admin> selectByMap(Map<String, Object> map);

    void updateById(Admin admin);
}
