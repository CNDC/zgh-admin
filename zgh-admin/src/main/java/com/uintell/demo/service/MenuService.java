package com.uintell.demo.service;

import com.uintell.demo.bean.MenuVO;

import java.util.List;

/**
 * @author admin
 * @date 2018/1/4 10:21
 */
public interface MenuService {
    List<MenuVO> getAuthMenus(String id);
}
