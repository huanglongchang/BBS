<%@taglib prefix="s" uri="/struts-tags"   %>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.zhbit.service.UserServiceImpl"%>
<%@page import="com.zhbit.domain.Users"%>
<%@page import="com.zhbit.service.MessageServiceImpl"%>
<%@page import="com.zhbit.domain.Message"%>
<%@page import="com.zhbit.service.PostServiceImpl"%>
<%@page import="com.zhbit.domain.Post"%>
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
    
    <title>My JSP 'showMessage.jsp' starting page</title>
    <link href="css/index.css" rel="stylesheet" type="text/css" />
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
  
  
  
 <%
System.out.println("--------------------");  
int MessageId=Integer.parseInt(request.getParameter("MessageId"));
System.out.println(MessageId);  
%>
<s:action name="selectMessageById" flush="true" namespace="/">
 </s:action>
<% 

Message message=(Message)session.getAttribute("message");
System.out.println(message.getTitle());  
System.out.println("----------------------------------------");  
  %> 
  
<div align="center">


<br>
<br>
<br>
<br>

<hr color="gray"  size="3">
     
    
     
     <td width="640" align="center" valign="top">
<table cellpadding="0" cellspacing="3" border="0" width="640">
	<tr>
		<td style="font-size:12px;" width="100px">
		标题：
		</td>
		<td style="font-size:12px;">
		<textarea readonly="readonly" style="width: 472px; "><%=message.getTitle()%></textarea> 
		
	 </td>
	</tr>
	<tr>
		<td style="font-size:12px;">
		内容：
		</td>
		<td style="font-size:12px;">
	<textarea readonly="readonly" style="width: 472px; "><%=message.getContent() %></textarea> 
	 </td>
	</tr>
	<tr>
		<td style="font-size:12px;">
		发布时间：
		</td>
		<td style="font-size:12px;">
		
		<textarea readonly="readonly" style="width: 471px; "><%=message.getNewDate() %></textarea> 
			
	 </td>
	</tr>
</table> 
<br>

<s:action name="selectAllPost" flush="true" namespace="/">
 </s:action>




<table cellpadding="0" cellspacing="3" border="1" width="800" style="height: 145px; ">
  <thead>
    <tr>
    <th align="center" style="width: 50px; ">aurthor</th>
      <th align="center" style="width:400px; ">content</th>
      <th align="center" style="width: 150px; ">Time</th>
    </tr>
    </thead>
 <%
List<Post> ls=(List<Post>)session.getAttribute("postList");
System.out.println("评论条目为"+ls.size());
if(ls!=null){
for(int i=0;i<ls.size();i++){
Post post=(Post)ls.get(i);
//System.out.println(post.getId()); 
%>


	<tr>
		<td style="font-size:20px; ">
		<%=post.getAurthor() %>
	 </td>
	 	<td style="font-size:20px;">
		<%=post.getContent() %>
	 </td>
	 	<td style="font-size:20px; ">
		<%=post.getNewDate() %> 
	 </td>
	
	</tr>

<% 
}
}
  %>	
<hr color="gray"  size="3">  
  
  
</table>
<br>
<br>
<hr color="gray"  size="3">  
 
<div >
<label>发表评论</label>
 <br>  <br> 
 <form action="addPost"method="POST"namespace="/">
 <input type="text"id="content"name="content" style="width: 409px; height: 31px"/> 
 <br> <br>
        <input type="submit" name="Submit" value="提交" />
        <input type="reset" name="Submit2" value="重置" />
  <input type="hidden" name="name" value="<%=name%>">
  <input type="hidden" name="messageId" value="<%=message.getId()%>">
  <input type="button" name="Submit2"onclick="javascript:history.back(1);" value="Back" />
 </form>

</div>


<%-- <%=post.getAurthor() %>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%=post.getContent() %>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%=post.getNewDate() %>   </tr><br> --%>

 
 


</div>
</body>
</html>
