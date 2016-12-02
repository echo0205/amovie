package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Posts;
import org.lanqiao.entity.Reply;
import org.lanqiao.utils.MyBatisUtil;

public class TestMyBatis {
	public static void main(String[] args) throws IOException {
//		List<Employee> list =MyBatisUtil.queryExecute("org.lanqiao.sqlxml.EmpMapper.selectEmployee", null);
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
//		MyBatisUtil.updateExecute(namespace, param);
		
//		Employee emp  = new Employee();
//		emp.setName("lu");
//		emp.setDeptId(1);
//		emp.setImgUrl("aweqe");
//		emp.setTelphone("46546");
//		emp.setEmail("44");
//		emp.setRegDate(new Date());
//		MyBatisUtil.updateExecute("org.lanqiao.sqlxml.EmpMapper.insertEmployee", emp);
		
//		Employee emp = (Employee) MyBatisUtil.queryOneExecute("org.lanqiao.sqlxml.EmpMapper.selectEmployeeByid", 6);
//		System.out.println(emp);
		//MyBatisUtil.deleteExecute("org.lanqiao.sqlxml.EmpMapper.deleteEmployeeById", 6);
//		List<Posts> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.PostsMapper.selectPosts", null);
//		for (Posts posts : list) {
//			System.out.println(posts);
//		}
//		List<Posts> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.PostsMapper.selectPostsByid", 1);
//		for (Posts posts : list) {
//			System.out.println(posts);
//		}
		List<HashMap<String, Object>> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.ReplyMapper.selectReplyByid", 1);
		for (HashMap<String, Object> hashMap : list) {
			System.out.println(hashMap.get("reply_id"));
		}
	}
}
