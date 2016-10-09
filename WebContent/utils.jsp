<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setCharacterEncoding("UTF-8");
	String url = basePath  +"";
%>
<html>
  <head>
    <base href="<%=basePath%>">
	<title>JSP模板</title>
	<script type="text/javascript" src="js/util.js"></script>
	<link rel="stylesheet" type="text/css" href="css/mldn.css">
  </head> 
  <body>
   


  </body>
</html>
