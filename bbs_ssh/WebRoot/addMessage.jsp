<%@taglib prefix="s" uri="/struts-tags"   %>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.zhbit.service.UserServiceImpl"%>
<%@page import="com.zhbit.domain.Users"%>
<%@page import="com.zhbit.service.MessageServiceImpl"%>
<%@page import="com.zhbit.domain.Message"%>
<%@page import="com.zhbit.action.MessageAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link href="css/index.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  

<div >        
 <ul id="nav"> 
<li ><a href="index.jsp">首页</a></li> 
<li><a href=" ">发帖</a></li> 
<li><a href=" ">我的帖子</a></li> 
<li><a href=" ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li> 
<li><a href=" ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li> 
<li><a href=" ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li> 
<li><a href=" ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li> 
<li><a href=" ">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</a></li> 

  <%

session=request.getSession();
String name=(String)session.getAttribute("name");
System.out.println(name);  
  if(name==null){
   %>
<li><a href="login.jsp">登录</a></li> 
<li><a href="regist.jsp">注册</a></li> 
</ul> 
<% } %>
<% if(name!=null){ %>
<li>欢迎您         <%= name %></li> 
<li><a href="updatePassword.jsp">修改密码</a></li> 
<li><a href="login.jsp">退出</a></li> 
</ul> 
<% } %>
</div>

<div align="center">
<br>
<br>
<hr color="gray"  size="3">
   <h1>    <p align="center"><font size=" 3" color="#FF3300">发帖</font></p></h1>  
   
   <form action="addMessageAction"method="POST"namespace="/">
<table cellpadding="0" cellspacing="3" border="0" width="640">
	<tr>
		<td style="font-size:12px;" width="100px">
		标题：
		</td>
		<td style="font-size:12px;">
		<textarea name="title" id="title"style="width: 472px; "></textarea> 
	 </td>
	</tr>
	<tr><br><br></tr>
	<tr>
		<td style="font-size:12px;">
		内容：
		</td>
		<td style="font-size:12px;">
	<textarea  name="content" id="content" style="width: 472px; height: 148px"></textarea> 
	 </td>
	</tr>
	
	<tr>
	  </tr>
</table> 
<br>     <input type="hidden" name="name" value="<%=name%>">
        <input type="submit" name="Submit" value="提交" />
        <input type="reset" name="Submit2" value="重置" />
  <input type="button" name="Submit2"onclick="javascript:history.back(1);" value="Back" />
   
 </form> 
<br>

</div>
  </body>
</html>
