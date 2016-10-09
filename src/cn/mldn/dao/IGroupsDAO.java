package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Groups;

public interface IGroupsDAO extends IDAO<Integer, Groups> {
	public List<Groups> findByRoles(Integer rid) throws SQLException;
}
