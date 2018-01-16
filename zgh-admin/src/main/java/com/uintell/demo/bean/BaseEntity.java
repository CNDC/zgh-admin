package com.uintell.demo.bean;

import java.io.Serializable;

public interface BaseEntity extends Serializable {
	String getId();

	void setId(String id);
}
