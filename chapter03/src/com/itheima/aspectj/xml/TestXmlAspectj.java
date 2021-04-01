package com.itheima.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.jdk.UserDao;

public class TestXmlAspectj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xmlPath="com/itheima/aspectj/xml/applicationContext.xml";
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");
		userDao.addUser();
	}

}
