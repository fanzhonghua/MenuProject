package cn.mldn.util.factory;

public class DAOFactory {
	private DAOFactory(){}
	public static <T>T getInstance(Class<T> cls) {
		try {
			return cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
