package com.wcx.Dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wcx.pojo.Data;

public class selins {
	static SqlSessionFactory factory;
	static {
		InputStream is=null;
		try {
			is = Resources.getResourceAsStream("myabtis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//使用工厂设计模式 
		factory = new SqlSessionFactoryBuilder().build(is);
		
	}
	
	public Data sel(){
		SqlSession session=factory.openSession();
		Data d= session.selectOne("a.b.selOne");
		session.commit();
		session.close();
		return d;
	}
	
	public int ins(Data a){
		SqlSession session=factory.openSession();
		int d= session.insert("a.b.insData",a);
		session.commit();
		session.close();
		return d;
	}
	public int ins1(Data a){
		SqlSession session=factory.openSession();
		int d= session.insert("a.b.insData1",a);
		session.commit();
		session.close();
		return d;
	}
	public int ins2(Data a){
		SqlSession session=factory.openSession();
		int d= session.insert("a.b.insData2",a);
		session.commit();
		session.close();
		return d;
	}
}