package com.uintell.demo.bean;

import java.util.Date;

public interface Recordable {

	String getCreateUser();

	void setCreateUser(String createUser);

	Date getCreateTime();

	void setCreateTime(Date createTime);

	String getUpdateUser();

	void setUpdateUser(String updateUser);

	Date getUpdateTime();

	void setUpdateTime(Date updateTime);

}
