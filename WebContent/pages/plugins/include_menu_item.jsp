<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.mldn.vo.*" %>
<%
	Member vo = (Member)session.getAttribute("member");
	
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="upload/emp/nophoto.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p><%=vo.getName() %></p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-slack"></i> 企业人事管理系统</li>
			<%
				//System.out.println("\n***********" + vo.getRole()) ;
				List<Groups> allGroups = vo.getRole().getGroups();
				//System.out.println("\n&&&&&&&&&&&" + allGroups.toString()) ;
				Iterator<Groups> iter = allGroups.iterator();
				//System.out.println("\n###########" + iter) ;
				while(iter.hasNext()){
					Groups gup = iter.next();
				
			%>
			<li class="treeview"><a href="<%=basePath%>pages/index.jsp"> <i
					class="fa fa-folder-open"></i> <span><%=gup.getTitle() %></span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
				<%
					Iterator<Actions> iterAc = gup.getActions().iterator();
					while(iterAc.hasNext()){
						Actions ac = iterAc.next();
				%>
					<li><a href="pages/admin/admin_list.jsp"><i class="fa fa-circle-o"></i>
							<%=ac.getTitle() %></a></li>
			<% 		} %>			
		</ul>
		<%} %>
	</section>
	<!-- /.sidebar -->
</aside>