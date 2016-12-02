package org.lanqiao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public  class  MyBatisUtil {
	public static SqlSessionFactory ssf = null;
	static{
		String resource = "MyBatis-config.xml";
		InputStream is;
		try {
			is = Resources.getResourceAsStream(resource );
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSession(){
		SqlSession session = ssf.openSession();//true
		return session;
	}
	/**
	 * 查找
	 * @param namespace
	 * @param param
	 * @return
	 */
	public static List queryExecute(String namespace,Object param){
		SqlSession session = getSession();
		List list = session.selectList(namespace, param);
		session.close();
		return list;
	}
	public static Object queryOneExecute(String namespace,Object param){
		SqlSession session = getSession();
		Object selectOne = session.selectOne(namespace, param);
		session.close();
		return selectOne;
	}
	/**
	 * 删除操作
	 * @param namespace
	 * @param param
	 */
	public static void deleteExecute(String namespace,Object param){
		SqlSession session = getSession();
		session.delete(namespace, param);
		session.commit();
		session.close();
	}
	/**
	 * 修改
	 * @param namespace
	 * @param param
	 */
	public static void updateExecute(String namespace,Object param){
		SqlSession session = getSession();
		session.update(namespace, param);
		session.commit();
		session.close();
	}
	/**
	 * 添加
	 * @param namespace
	 * @param param
	 */
	public static void insertExecute(String namespace,Object param){
		SqlSession session = getSession();
		session.insert(namespace, param);
		session.commit();
		session.close();
	}
}