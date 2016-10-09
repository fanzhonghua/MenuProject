package cn.mldn.dao;

import java.sql.SQLException;
import java.util.Date;

import cn.mldn.util.dao.IDAO;
import cn.mldn.vo.Member;

public interface IMemberDAO extends IDAO<String, Member> {
	public boolean doUpdate(String mid,Date indate) throws SQLException;
}
