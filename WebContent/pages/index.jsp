<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
	String url = basePath + "login.jsp";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<jsp:include page="/pages/plugins/include_javascript_head.jsp" />
</head>

	<body class="hold-transition skin-blue sidebar-mini">
	<%  if(session.getAttribute("member")!=null){ %>
		<div class="wrapper">
			<!-- 导入头部标题栏内容 -->
			<jsp:include page="/pages/plugins/include_title_head.jsp" />
			<!-- 导入左边菜单项 -->
			<jsp:include page="/pages/plugins/include_menu_item.jsp" />
			<div class="content-wrapper text-center">
				<!-- 此处编写需要显示的页面 -->
				<img src="<%=basePath%>/images/welcome_index.jpg" style="">
			</div>
			<!-- 导入公司尾部认证信息 -->
			<jsp:include page="/pages/plugins/include_title_foot.jsp" />
			<!-- 导入右边工具设置栏 -->
			<jsp:include page="/pages/plugins/include_menu_sidebar.jsp" />
			<div class="control-sidebar-bg"></div>
		</div>
		<jsp:include page="/pages/plugins/include_javascript_foot.jsp" />
		<%  }else {%>
	   <jsp:include page="/pages/time_div.jsp">
   		<jsp:param name="msg" value="您还未登录账号，请先登录！" />
   		<jsp:param name="url" value="<%=url%>" />
   </jsp:include>
  <%} %>
	</body>

</html>
