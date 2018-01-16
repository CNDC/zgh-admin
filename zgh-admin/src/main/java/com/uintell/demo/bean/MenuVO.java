package com.uintell.demo.bean;

import java.util.List;

/**
 * Created by chen on 2017/11/4.
 */
public class MenuVO {

	private String name; //名称
	private String parentName; //父菜单
	private String icon; //icon
	private String url; //路径
	private String type; //类型(btn按钮，menu菜单)
	private String btnCode; //按钮码
	private List<MenuVO> menuList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBtnCode() {
		return btnCode;
	}

	public void setBtnCode(String btnCode) {
		this.btnCode = btnCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}
}
