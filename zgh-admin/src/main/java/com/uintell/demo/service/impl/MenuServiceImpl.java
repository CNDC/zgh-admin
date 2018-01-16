package com.uintell.demo.service.impl;

import com.google.common.collect.Lists;
import com.uintell.demo.bean.Menu;
import com.uintell.demo.bean.MenuVO;
import com.uintell.demo.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单业务逻辑层
 *
 * @author liulanghan
 * @since 2017-11-04 17:42:44
 */
@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {


    /*public List<Menu> getRootMenus() {
        return menuDao.getRootMenus();
    }

    public List<Menu> getMenusByParent(String parentId) {
        return menuDao.getMenusByParent(parentId);
    }

    public List<String> listIdByRoleId(String roleId) {
        return menuDao.listIdByRoleId(roleId);
    }*/

    public List<String> getAuthMenuIds(String adminId) {
        List<String> authMenuIds = getBaseDao().queryForList("", adminId, String.class);//获取角色菜单id列表
        return authMenuIds;
    }

    public List<MenuVO> getAuthMenus(String adminId) {
        List<String> authMenuIds = this.getAuthMenuIds(adminId);
        //查询根菜单列表
        List<Menu> menuList = listParentId("0", authMenuIds);
        //递归获取子菜单
        List<MenuVO> treeList = getMenuTreeList(menuList, authMenuIds);
        return treeList;
    }

    /**
     * 递归
     */
    private List<MenuVO> getMenuTreeList(List<Menu> menuList, List<String> menuIdList) {
        List<MenuVO> menuVOList = Lists.newArrayList();

        for (Menu menu : menuList) {
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(menu, menuVO);

            menuVO.setMenuList(getMenuTreeList(listParentId(menu.getId(), menuIdList), menuIdList));

            menuVOList.add(menuVO);
        }
        return menuVOList;
    }

    public List<Menu> listParentId(String parentId, List<String> menuIdList) {
        //根据角色菜单id查询跟根菜单列表
        List<Menu> menuList = getBaseDao().queryForList("menuMapper.findListParentId", parentId, Menu.class);
        if (menuIdList == null) {
            return menuList;
        }

        List<Menu> adminMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menuIdList.contains(menu.getId())) {
                adminMenuList.add(menu);
            }
        }
        return adminMenuList;
    }
}
