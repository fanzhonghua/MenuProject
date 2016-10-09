package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Actions;

public interface IActionsDAO extends IDAO<Integer, Actions> {
	public List<Actions> findByGroups(Integer gid) throws SQLException;
	
}
