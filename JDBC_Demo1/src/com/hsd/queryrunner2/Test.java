package com.hsd.queryrunner2;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;


public class Test {
	public static <V> void main(String[] args) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student where sid=?";
/*		Student student2 = runner.query(sql, new BeanHandler<>(Student.class), 10);
		System.out.println(student2);
		System.out.println();
		
		sql = "select count(*) from student";
		Long counts = runner.query(sql, new ScalarHandler<>());
		System.out.println(counts.intValue());
		System.out.println();
		
		
		sql = "select * from student";
		List<Student> list = runner.query(sql, new BeanListHandler<>(Student.class));
		for (Student student : list) {
			System.out.println(student);
		}
		
		sql = "select * from student where sname like ?";
		List<Student> stuList = runner.query(sql, new BeanListHandler<>(Student.class),"%小%");
		for (Student student : stuList) {
			System.out.println(student);
		}
		System.out.println();
		
		sql = "select * from student";
		Map<String, Object> map = runner.query(sql, new MapHandler());
		//根据映射关系取数据
		for (Map.Entry<String, Object> mapp: map.entrySet()) {
			System.out.println(mapp.getKey()+"\t"+mapp.getValue());
		}
		
		//先取出key，再根据 key取出相应的值
		for(String key : map.keySet()){
			System.out.println(key+"\t"+map.get(key));
		}*/
		
		sql = "select * from student where sid = ?";
		Object[] objects = runner.query(sql, new ArrayHandler(),1);
		for (Object object : objects) {
			System.out.print(object+"\t");
		}
		System.out.println("\n");
		
		
		sql = "select * from student";
		List<Object[]> list = runner.query(sql, new ArrayListHandler());
		for (Object[] objects2 : list) {
			for (Object object : objects2) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		System.out.println();
		
		sql = "select * from student where sid = ?";
		Map<String, Object> map = runner.query(sql, new MapHandler(),1);
		for (Entry<String, Object> m : map.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
		System.out.println();
		
		sql = "select * from student";
		List<Map<String,Object>> list2 = runner.query(sql, new MapListHandler());
		for (Map<String, Object> map2 : list2) {
			for (String key : map2.keySet()) {
				System.out.print(key+"\t"+map2.get(key)+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		Map<Object, Map<String, Object>> map3 = runner.query(sql, new KeyedHandler<>("sid"));
		for (Entry<Object, Map<String, Object>> m : map3.entrySet()) {
//			System.out.println(m.getKey());
			Map<String, Object> mm = m.getValue();
			for(String key : mm.keySet()){
				System.out.print(mm.get(key)+"\t");
			}
			System.out.println();
		}
	}

}
