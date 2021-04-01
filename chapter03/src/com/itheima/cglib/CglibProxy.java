package com.itheima.cglib;
import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import javax.net.ssl.CertPathTrustManagerParameters;
import com.itheima.aspect.MyAspect;
//代理类CglibProxy
public class CglibProxy implements MethodInterceptor {
	//代理方法
	public Object createProxy(Object target) {
		//创建动态类对象
		Enhancer enhancer=new Enhancer();
		//确定需要增强的类，设置其父类
		enhancer.setSuperclass(target.getClass());
		//添加回调函数
		enhancer.setCallback(this);
		//返回创建的代理类
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
