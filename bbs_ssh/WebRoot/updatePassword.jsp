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
    
    <title>My JSP 'updatePassword.jsp' starting page</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  </head>
  
  <body>
  
  <%
session=request.getSession();
String name=(String)session.getAttribute("name");
System.out.println("9");  
System.out.println(name);  
   %>

  <s:action name="getUserByName" flush="true" namespace="/">
 </s:action>
    <% 
Users user=(Users)session.getAttribute("user");
//System.out.println(user.getEmail());  
%>


 <div class="container">
  <p align="center"><font size=" 3" color="#FF3300">修改密码</font></p>
<form method="POST" action="upDatePassword" namespace="/">
<table align="center">
    <tr>
      <td ">用户名：</td>
      <td ><label>
      
        <input name="name" type="text" id="name" value="<%=user.getName()%>"  readonly="readonly"/>
      </label></td>
    </tr>
    <tr>
      <td>新密码：</td>
      <td><label>
        <input name="password" type="password" id="password"value="<%=user.getPassword()%>"  />
      </label></td>
      <td><s:fielderror fieldName="password"/></td>
    </tr>   
   
  <tr>
      <td>确认密码：</td>
      <td><label>
        <input name="rePassword" type="password" id="rePassword" />
      </label></td>
      <td><s:fielderror fieldName="rePassword"/></td>
    </tr>  

    <tr>
      <td><label>
        <input type="submit" name="Submit" value="提交" />
      </label></td>
      <td><label>
      
        <input type="button" name="Submit2"onclick="javascript:history.back(1);" value="Back" />
      </label></td>
    </tr>
</table>
</form>
</div>
   
   
   
  </body>
</html>
