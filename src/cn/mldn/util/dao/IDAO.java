package cn.mldn.util.dao;

import java.sql.SQLException;

public interface IDAO<K, V> {
	public V findById(K id)throws SQLException;
	public boolean doCreate(V vo)throws SQLException;
}
