package com.uintell.demo.service;

import com.uintell.demo.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2018/1/3 16:59
 */
public interface AdminService {

    List<User> selectByMap(Map<String, Object> map);

    void updateById(User user);
}
