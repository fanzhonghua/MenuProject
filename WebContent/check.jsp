<%@page import="cn.mldn.util.MD5Code"%>
<%@page import="cn.mldn.service.impl.MemberServiceImpl"%>
<%@page import="cn.mldn.util.factory.ServiceFactory"%>
<%@page import="cn.mldn.service.IMemberService"%>
<%@page import="cn.mldn.util.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setCharacterEncoding("UTF-8");
	String url = basePath  +"login.jsp";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/util.js"></script>
	<title>跳转中....</title>
  </head> 
  <body>
   <%
   		String salt="bWxkbmphdmE=";
   		String mid = request.getParameter("mid");
   		String msg = "账号密码错误，请重新输入账号密码。";
   		String code = request.getParameter("code");
   		String rand = session.getAttribute("rand").toString();
   		if(rand.equalsIgnoreCase(code)){
   			String password = new MD5Code().getMD5ofStr(request.getParameter("password")+"{!("+salt+")!}");
   	   		IMemberService memService = ServiceFactory.getInstance(MemberServiceImpl.class);
   	   		boolean flag = false ;
   	   		try{
   	   			Map<String,Object> map =memService.login(mid, password,request.getRemoteAddr(),request.getHeader("user-agent"));
   	   			if(map!=null){
   	   				flag = (Boolean)map.get("flag");
   	   			}
   	   			if(flag){
   	   	   			session.setAttribute("member", map.get("member")) ;
   	   	   			msg = "账号登录成功，欢迎光临。" ;
   	   	   			url = basePath+"pages/index.jsp";
   	   	   		}
   	   		}catch(Exception e){
   	   			e.printStackTrace();
   	   		}
   		}else{
   			msg = "验证码错误，请重新输入。";
   		}
   		
   %>
   <jsp:include page="pages/time_div.jsp">
   		<jsp:param name="msg" value="<%=msg%>" />
   		<jsp:param name="url" value="<%=url %>" />
   </jsp:include>
  </body>
</html>
