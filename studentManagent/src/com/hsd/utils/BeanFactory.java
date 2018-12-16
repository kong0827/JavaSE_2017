package com.hsd.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.hsd.domain.Student;

/**
 * 想要成为根据xml生成bean的工厂工具类
 * 工具类：
 * 	1、里面所有的方法都是static
 *  2、不能实例化
 * 
 */
public class BeanFactory {
	private BeanFactory() {	}
	private static  ArrayList<BeanConfig> cache=new ArrayList<>();
	static{		
		// 解析xml中的数据放到map<字段名,字段值>中
		SAXReader reader=new SAXReader();
		Document document=null;
		try {
			document = reader.read("src\\beans.xml");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		//找到所有的<bean>元素
		List<Element> beans = root.elements("bean");
		for (Element bean : beans) {
			//找到每一个bean中的id属性
			String id=bean.attributeValue("id");
			
			//找到每一个bean中的className属性
			String className = bean.attributeValue("className");
			Map<String,String> map=new HashMap<>();
			//System.out.println(className);
			//找到每一个<bean>中的<property>

			List<Element> props = bean.elements();
			for (Element prop : props) {
				//System.out.println(prop);
				map.put(prop.attributeValue("name"),prop.attributeValue("value"));
			}
			//System.out.println(map);
			//把className和map存到BeanConfig对象中
			BeanConfig bc=new BeanConfig(id,className, map);
		
			cache.add(bc);			
		}
	}
	//根据id去生成对应的对象并返回
	public static Object getBean(String id) {
		Object bean=null;
		try{
			for (BeanConfig beanConfig : cache) {
				if(id.equals(beanConfig.getId())){//找到了要生成的对象信息
					String className = beanConfig.getClassName();
					
					Class clazz=Class.forName(className);
					Object obj = clazz.newInstance();//三个对象  分别是 Student Car Card类的对象
					Field[] fs = clazz.getDeclaredFields();
					if(fs!=null){
						
						for (Field f : fs) {
							BeanUtils.setProperty(obj, f.getName(), beanConfig.getMap().get(f.getName())); 
						}
					}
					bean=obj;
				}			
			}
		}catch(Exception e){
			//把编译器的异常转成运行时异常
			throw new RuntimeException(e);
		}		
		return bean;
	}
}
