package cn.mldn.service;

import java.util.Map;

import cn.mldn.exception.MemberLoginException;

public interface IMemberService {
	public Map<String,Object> login(String mid,String password,String ip,String note) throws MemberLoginException;
	
}
