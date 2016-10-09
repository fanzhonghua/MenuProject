package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.dao.IGroupsDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.vo.Groups;

public class GroupsDAOImpl extends AbstractDAO implements IGroupsDAO {

	@Override
	public Groups findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groups> findByRoles(Integer rid) throws SQLException {
		String sql = "select gid,title from groups where gid in("
				+ " select gid from role_groups where rid = ?) ";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, rid);
		ResultSet rs = super.pstmt.executeQuery();
		List<Groups> all = new ArrayList<Groups>();
		while(rs.next()){
			Groups gs  = new Groups();
			gs.setGid(rs.getInt(1));
			gs.setTitle(rs.getString(2));
			all.add(gs);
		}
		return all;
	}

	@Override
	public boolean doCreate(Groups vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}