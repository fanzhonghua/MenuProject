package cn.mldn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.mldn.dao.IMemberDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.vo.Member;

public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {

	@Override
	public Member findById(String id) throws SQLException {
		String sql = "select mid,password,name,lastdate,rid from member where mid = ?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, id);
		ResultSet rs = super.pstmt.executeQuery();
		Member vo =null;
		if(rs.next()){
			vo = new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setLastdate(rs.getTimestamp(4));
		}
		return vo;
	}

	@Override
	public boolean doCreate(Member vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(String mid, Date indate) throws SQLException {
		String sql ="update member set lastdate=? where mid=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setTimestamp(1, new java.sql.Timestamp(indate.getTime()));
		super.pstmt.setString(2, mid);
		return super.pstmt.executeUpdate()>0;
	}



}