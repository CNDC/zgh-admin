package com.uintell.demo.bean;



/**
* 角色菜单
* @author mbg
* @since 2017-12-05 11:23:36
*/
public class RoleMenu implements  BaseEntity{

    private String id; //
    private String roleId; //角色id
    private String menuId; //菜单id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }


}
