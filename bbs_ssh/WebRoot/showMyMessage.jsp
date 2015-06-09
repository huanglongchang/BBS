<%@taglib prefix="s" uri="/struts-tags"   %>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.zhbit.service.UserServiceImpl"%>
<%@page import="com.zhbit.domain.Users"%>
<%@page import="com.zhbit.service.MessageServiceImpl"%>
<%@page import="com.zhbit.domain.Message"%>
<%@page import="com.zhbit.action.MessageAction"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> <!--导入Struts 2 标签库-->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <style>
		
			/* -------------------------------------- */
			ol{
				counter-reset: li;
				list-style: none;
				*list-style: decimal;
				font: 15px 'trebuchet MS', 'lucida sans';
				padding: 0;
				margin-bottom: 4em;
				text-shadow: 0 1px 0 rgba(255,255,255,.5);
			}

			ol ol{
				margin: 0 0 0 2em;
			}
			/* -------------------------------------- */

			.circle-list li{
			    padding: 2.5em;
			    border-bottom: 1px dashed #ccc;
			}

			.circle-list h2{
			    position: relative;
			    margin: 0;
			}

			.circle-list p{
			    margin: 0;
			}

			.circle-list h2:before{
			    content: counter(li);
			    counter-increment: li;
			    position: absolute;    
			    z-index: -1;
			    left: -1.3em;
			    top: -.8em;
			    background: #f5f5f5;
			    height: 1.5em;
			    width: 1.5em;
			    border: .1em solid rgba(0,0,0,.05);
			    text-align: center;
			    font: italic bold 1em/1.5em Georgia, Serif;
			    color: #ccc;
			    -moz-border-radius: 1.5em;
			    -webkit-border-radius: 1.5em;
			    border-radius: 1.5em;
			    -webkit-transition: all .2s ease-out;
			    -moz-transition: all .2s ease-out;
			    -ms-transition: all .2s ease-out;
			    -o-transition: all .2s ease-out;
			    transition: all .2s ease-out;    
			}

			.circle-list li:hover h2:before{
			    background-color: #ffd797;
			    border-color: rgba(0,0,0,.08);
			    border-width: .2em;
			    color: #444;
			    -webkit-transform: scale(1.5);
			    -moz-transform: scale(1.5);
			    -ms-transform: scale(1.5);
			    -o-transform: scale(1.5);
			    transform: scale(1.5);
			}
		</style>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMyMessage.jsp' starting page</title>
    
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
  
  <body >

  
 <div >        
 <ul id="nav"> 
<li ><a href="index.jsp">首页</a></li> 
<li><a href="addMessage.jsp">发帖</a></li> 
<li><a href="showMyMessage.jsp">我的帖子</a></li> 
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


 <s:action name="getAllMeAction" flush="true" namespace="/">
 </s:action>


<div align="left">
 <ol   class="circle-list">
 <%

List<Message> al=null;	
al=(List<Message>)session.getAttribute("messageList");
for(Message n:al){
%>
		    <li>
 <h2><form action="deleteMessage" method="POST" namespace="/"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <%= n.getId()%>   &nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="showMessage.jsp?MessageId=<%= n.getId()%> "> <%= n.getTitle()%> </a>  &nbsp&nbsp&nbsp&nbsp  </a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <%= n.getNewDate()%>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
 <input type="hidden" name="messageId"  id="messageId" value=<%= n.getId()%>><input type="submit" name="Submit" value="DELETE" onclick="return window.confirm('你确定要删除吗？')"/></form></h2>

		    </li>
	<%	
	}	
 %>	    
		</ol>	
		
		
		
		</div>	

   <br>
  </body>
</html>
