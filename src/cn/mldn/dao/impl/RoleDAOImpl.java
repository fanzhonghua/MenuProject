package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.mldn.dao.IRoleDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.vo.Role;

public class RoleDAOImpl extends AbstractDAO implements IRoleDAO {

	@Override
	public Role findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findByMember(String mid) throws SQLException {
		String sql = "select rid,title from role where rid in ( "
				+ " select rid from member where mid= ?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, mid);
		ResultSet rs = super.pstmt.executeQuery();
		Role vo = null;
		if(rs.next()){
			vo = new Role();
			vo.setRid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
		}
		return vo;
	}

	@Override
	public boolean doCreate(Role vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}