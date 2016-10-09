package cn.mldn.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.mldn.util.dbc.DatabaseConnection;


public class ServiceProxy implements InvocationHandler{
	private Object real;
	public <T>T bind(Class<T> cls){
		try {
			this.real = cls.newInstance();
			return (T)Proxy.newProxyInstance(this.real.getClass().getClassLoader(),
					this.real.getClass().getInterfaces(), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = null;
		try {
			if(method.getName().startsWith("add")||
					method.getName().startsWith("edit")||
					method.getName().startsWith("remove")||
					method.getName().startsWith("login")){
				try {
					DatabaseConnection.getConnection().setAutoCommit(false);
					ret = method.invoke(this.real, args);
					DatabaseConnection.getConnection().commit();
				} catch (Exception e) {
					DatabaseConnection.getConnection().rollback();
					throw e;
				}
			}else{
				ret  = method.invoke(this.real, args);
			}
		}catch(Exception e){
			e.printStackTrace();
		} 
		finally {
			DatabaseConnection.close();
		}
		return ret;
	}
	
}
