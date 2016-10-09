package cn.mldn.dao;

import java.sql.SQLException;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Role;

public interface IRoleDAO extends IDAO<Integer, Role> {
	public Role findByMember(String mid) throws SQLException;
}
