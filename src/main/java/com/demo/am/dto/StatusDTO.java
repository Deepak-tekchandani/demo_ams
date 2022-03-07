package com.demo.am.dto;

import java.util.List;

public class StatusDTO {
	
	private int code;
	private String msg;
	private Object object;
	private List<Object> objectList;
	
	public StatusDTO(int code, String msg, Object object) {
		this.code = code;
		this.msg = msg;
		this.object = object;
	}
	
	public StatusDTO(int code, String msg, List<Object> objectList) {
		this.code = code;
		this.msg = msg;
		this.objectList=objectList;
	}
	
	
	public StatusDTO(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
}