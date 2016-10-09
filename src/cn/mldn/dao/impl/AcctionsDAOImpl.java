package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.dao.IActionsDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.vo.Actions;
import cn.mldn.vo.Groups;

public class AcctionsDAOImpl extends AbstractDAO implements IActionsDAO {

	@Override
	public Actions findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actions> findByGroups(Integer gid) throws SQLException {
		String sql = "select actid,title,url from actions where gid=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setInt(1, gid);
		ResultSet rs = super.pstmt.executeQuery();
		List<Actions> all = new ArrayList<Actions>();
		while(rs.next()){
			Actions vo = new Actions();
			vo.setActid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setUrl(rs.getString(3));
			all.add(vo);
		}
		return all;
	}

	@Override
	public boolean doCreate(Actions vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}