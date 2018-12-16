package com.hsd.utils;


import java.util.Map;
//用来保存xml中一个<bean>元素中的信息：id,类名，{字段名=字段值}
public class BeanConfig {
	/**
	 * @param id
	 * @param className
	 * @param map
	 */
	public BeanConfig(String id, String className, Map<String, String> map) {
		super();
		this.id = id;
		this.className = className;
		this.map = map;
	}
	private String id;
	private String className;
	private Map<String,String> map;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "BeanConfig [id=" + id + ", className=" + className + ", map=" + map + "]";
	}
	

}
