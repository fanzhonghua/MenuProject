package cn.mldn.util.factory;

import cn.mldn.util.proxy.ServiceProxy;

public class ServiceFactory {
	private ServiceFactory(){}
	public static <T>T getInstance(Class<T> cls){
		return new ServiceProxy().bind(cls);
	}
}
