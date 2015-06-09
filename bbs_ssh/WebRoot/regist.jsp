<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> <!--导入Struts 2 标签库-->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

     <p align="center"><font size=" 3" color="#FF3300">用户注册</font></p>
     
     
<form method="POST" action="addUser" namespace="/">
<table align="center">
    <tr>
      <td ">用户名：</td>
      <td ><label>
      
        <input name="name" type="text" id="name" />
      </label></td>
      <td><s:fielderror fieldName="name"/></td>
 
    </tr>
    <tr>
      <td>密码：</td>
      <td><label>
        <input name="password" type="password" id="password" />
      </label></td>
      <td><s:fielderror fieldName="password"/></td>
    </tr>
   <!--  <tr>
      <td>重输密码：</td>
      <td><label>
        <input name="password1" type="password" id="password1" />
      </label></td>
    </tr> -->
   
    <tr>
      <td>性别：</td>
      <td><label>
        <input name="sex" type="radio" value="1" checked="checked" />
      男
      <input type="radio" name="sex" value="2" />
      女</label></td>
       
    </tr>
  <tr>
                   <td>邮箱</td>
                   
                   <td>
                       <input type="text" name="email"> 
                       
                     <!--   <select>
                       <option value="163.com" >qq.com</option>
                       <option value="163.com" >126.com</option>
                       <option value="163.com" >163.com</option>
                       </select>
                       -->
                   </td>
                     <td><s:fielderror fieldName="email"/></td>
                </tr>
    <tr>
      <td><label>
        <input type="submit" name="Submit" value="提交" />
      </label></td>
      <td><label>
        <input type="reset" name="Submit2" value="重置" />
      </label></td>
    </tr>
</table>
</form>

     <br>
  </body>
</html>
