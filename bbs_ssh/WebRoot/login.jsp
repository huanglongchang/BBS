
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> <!--导入Struts 2 标签库-->
<html lang="en">

<head>

<meta charset="utf-8">
    <title>Sign in &middot; Twitter Bootstrap</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!-- Le styles -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="../assets/ico/favicon.png">


</head>



<body> 
<%-- 用户登录
	
	<s:form action="checkLogin" namespace="/">
	<s:textfield name="name" style="font-size:12px;width: 120px;"
		label="登录名称" />
		<br><s:fielderror fieldName="name"/>
	<s:password name="password" style="font-size:12px;width:120px;"
		label="登录密码" />
		<br>
		<s:fielderror fieldName="password"/>
	<s:submit value=" 登录 " ></s:submit>
	
	</s:form> --%>
	
	<div class="container">
      <form method="POST" action="checkLogin" namespace="/" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="name" type="text" id="name"  class="input-block-level" placeholder="Email address"><s:fielderror fieldName="name" />
        <input name="password" type="password"	id="password" class="input-block-level" placeholder="Password"><s:fielderror fieldName="password" />
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
	
	
	
	
	
	
<%-- 	<form method="POST" action="checkLogin" namespace="/">
		<table align="center">

			<tr>
				<td>用户名：</td>
				<td><label> <input name="name" type="text" id="name" />

				</label></td>
				<td><s:fielderror fieldName="name" /></td>
			</tr>

			<tr>

				<td>密 码：</td>

				<td><label> <input name="password" type="password"
						id="password" />

				</label></td>
				<td><s:fielderror fieldName="password" /></td>
			</tr>

			<tr>

				<td><label> <input type="submit" name="Submit"
						value="登录" />

				</label></td>

				<td align="center"><label><a href="regist.jsp"> 注册</a></label></td>

			</tr>

		</table>
 --%>
		<p>&nbsp;</p>

		<script src="../assets/js/jquery.js"></script>
		<script src="../assets/js/bootstrap-transition.js"></script>
		<script src="../assets/js/bootstrap-alert.js"></script>
		<script src="../assets/js/bootstrap-modal.js"></script>
		<script src="../assets/js/bootstrap-dropdown.js"></script>
		<script src="../assets/js/bootstrap-scrollspy.js"></script>
		<script src="../assets/js/bootstrap-tab.js"></script>
		<script src="../assets/js/bootstrap-tooltip.js"></script>
		<script src="../assets/js/bootstrap-popover.js"></script>
		<script src="../assets/js/bootstrap-button.js"></script>
		<script src="../assets/js/bootstrap-collapse.js"></script>
		<script src="../assets/js/bootstrap-carousel.js"></script>
		<script src="../assets/js/bootstrap-typeahead.js"></script>
</body></html>

