package com.itheima.jdk;

public class JdkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����������
		JdkProxy jdkProxy=new JdkProxy();
		//����Ŀ�����
		UserDao userDao=new UserDaoImpl();
		//�Ӵ�������л�ȡ��ǿ���Ŀ�����
		UserDao userDao1=(UserDao) jdkProxy.createProxy(userDao);
		//ִ�з���
		userDao1.addUser();
		userDao1.deleteUser();
	}

}
