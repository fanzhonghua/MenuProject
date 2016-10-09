package cn.mldn.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.dao.IActionsDAO;
import cn.mldn.dao.IGroupsDAO;
import cn.mldn.dao.ILogsDAO;
import cn.mldn.dao.IMemberDAO;
import cn.mldn.dao.IRoleDAO;
import cn.mldn.dao.impl.AcctionsDAOImpl;
import cn.mldn.dao.impl.GroupsDAOImpl;
import cn.mldn.dao.impl.LogDAOImpl;
import cn.mldn.dao.impl.MemberDAOImpl;
import cn.mldn.dao.impl.RoleDAOImpl;
import cn.mldn.exception.InvalidateRoleException;
import cn.mldn.exception.MemberInvalidatePasswordException;
import cn.mldn.exception.MemberLoginException;
import cn.mldn.exception.MemberNoExistsException;
import cn.mldn.service.IMemberService;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.vo.Actions;
import cn.mldn.vo.Groups;
import cn.mldn.vo.Logs;
import cn.mldn.vo.Member;
import cn.mldn.vo.Role;

public class MemberServiceImpl implements IMemberService {

	@Override
	public Map<String, Object> login(String mid, String password,String ip,String note) throws MemberLoginException {
		boolean flag = false;
		Member vo = null;
		Map<String,Object> map = new HashMap<String,Object>();
		IMemberDAO memDAO = DAOFactory.getInstance(MemberDAOImpl.class);
		try {
			vo = memDAO.findById(mid);
			if(vo==null){
				throw new MemberNoExistsException("用户名不存在");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(vo.getPassword().equals(password)){
			flag = true;
			Date loginDate = new Date();
			Logs logVo = new Logs();
			logVo.setIp(ip);
			logVo.setIndate(loginDate);
			logVo.setMid(mid);
			logVo.setNote(note);
			ILogsDAO logDAO = DAOFactory.getInstance(LogDAOImpl.class);
			try {
				if(memDAO.doUpdate(mid, loginDate)){
					logDAO.doCreate(logVo);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			IRoleDAO roleDAO = DAOFactory.getInstance(RoleDAOImpl.class);
			try {
				Role role = roleDAO.findByMember(vo.getMid());
				List<Groups> allGroups =null;
				if(role==null){
					throw new InvalidateRoleException("匹配角色权限错误");
				}else{
					IGroupsDAO groupsDAO = DAOFactory.getInstance(GroupsDAOImpl.class);
					allGroups = groupsDAO.findByRoles(role.getRid());
					Iterator<Groups> iter = allGroups.iterator();
					IActionsDAO acitonsDAO = DAOFactory.getInstance(AcctionsDAOImpl.class);
					while(iter.hasNext()){
						Groups gup = iter.next();
						gup.setActions(acitonsDAO.findByGroups(gup.getGid()));
						Iterator<Actions> iters = acitonsDAO.findByGroups(gup.getGid()).iterator();
						while(iters.hasNext()){
							System.out.println(iters.next());
						}
//						System.out.println(gup.getGid());
					}
					role.setGroups(allGroups);
					vo.setRole(role);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			throw new MemberInvalidatePasswordException("密码不正确");
		}
		map.put("flag", flag);
		map.put("member", vo); 
		return map;
	}

}
