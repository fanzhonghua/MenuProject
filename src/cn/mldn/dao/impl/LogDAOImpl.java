package cn.mldn.dao.impl;

import java.sql.SQLException;

import cn.mldn.dao.ILogsDAO;
import cn.mldn.util.dao.AbstractDAO;
import cn.mldn.vo.Logs;

public class LogDAOImpl extends AbstractDAO implements ILogsDAO {

	@Override
	public Logs findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreate(Logs vo) throws SQLException {
		String sql = "insert into logs(lid,mid,indate,ip,note) values(logs_seq.nextval,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getMid());
		super.pstmt.setTimestamp(2, new java.sql.Timestamp(vo.getIndate().getTime()));
		super.pstmt.setString(3, vo.getIp());
		super.pstmt.setString(4, vo.getNote());
		return super.pstmt.executeUpdate()>0;
	}

}