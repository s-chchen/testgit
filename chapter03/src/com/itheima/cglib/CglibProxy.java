package com.itheima.cglib;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import javax.net.ssl.CertPathTrustManagerParameters;
import com.itheima.aspect.MyAspect;
//������CglibProxy
public class CglibProxy implements MethodInterceptor {
	//������
	public Object createProxy(Object target) {
		//������̬�����
		Enhancer enhancer=new Enhancer();
		//ȷ����Ҫ��ǿ���࣬�����丸��
		enhancer.setSuperclass(target.getClass());
		//��ӻص�����
		enhancer.setCallback(this);
		//���ش����Ĵ�����
		return enhancer.create();
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		MyAspect myAspect=new MyAspect();
		myAspect.check_Permissions();
		Object obj=methodProxy.invokeSuper(proxy, args);
		myAspect.log();
		return obj;
	}

}
