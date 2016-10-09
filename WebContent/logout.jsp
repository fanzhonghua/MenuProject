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
   		session.invalidate();
   		String msg = "注销成功。";
   %>
   <jsp:include page="pages/time_div.jsp">
   		<jsp:param name="msg" value="<%=msg%>" />
   		<jsp:param name="url" value="<%=url %>" />
   </jsp:include>
  </body>
</html>
