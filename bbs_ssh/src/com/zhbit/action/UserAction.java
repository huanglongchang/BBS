/**
 * 
 */
package com.zhbit.action;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.domain.Users;
import com.zhbit.service.UserService;

/**
 * @author Administrator
 * 
 */
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user;

	@Resource
	private UserService userService;

	private String rePassword;
	private String name;
	private String password;
	private String sex;
	private String email;
	private int type;
	private List<Users> users;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	
	
	
	public String upDatePassword() {
		System.out.println("=============================");
		System.out.println("进入更新密码Action");
		userService.upDatePassword(name, password);
		return "success";

	}
	

	
	
	 public void getUserByName(){
		 user = userService.getUserByName(name);
		 System.out.println("++++++++++++++++++++++++++++++++++++++");
		 System.out.println(user.getName());
		 HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", user);// 将登录用户存储至Session中	 
	 }

	 
	public String login() {
		System.out.println("=============================");
		user = userService.getLogin(name, password);

		if (user != null) {
			System.out.println("+++++++++++++++++++++++++++++++");
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("name", name);// 将登录用户存储至Session中
			return "success";
		} else {
			System.out.println("-------------------------------");
			this.addFieldError("name", "用户名或密码不正确！");
			return "input";
		}
	}

	public void validateLogin() {

		System.out.println("进入用户登录校验方法");
		this.clearErrors();

		/*
		 * if(name==null){ this.addFieldError("name" , "用户名不能为空");
		 * System.out.println("OK3"); } if(password==null){
		 * this.addFieldError("password" , "密码不能为空"); System.out.println("OK3");
		 * }
		 */
		if (name == null || "".equals(name.trim())) {
			this.addFieldError("name", "用户名不能为空！");
		}
		/*
		 * if
		 * (!Pattern.compile("^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$").matcher(
		 * username.trim()).matches()) { this.addFieldError("username",
		 * "用户名长度必须在5-20之间，且以字母开头，可带数字、_和.的字符串！"); }
		 */
		if (password == null || "".equals(password.trim())) {
			this.addFieldError("password", "密码不能为空！");
		}

	}

	public String addUser() {
		// System.out.println(name+" "+password);
		// user=null;
		if (sex == "1") {
			sex = "男";
		} else {
			sex = "女";
		}
		type = 1;
		/*
		 * System.out.println(sex); System.out.println(type);
		 * System.out.println(name); System.out.println(password);
		 * System.out.println(email);
		 */
		// System.out.println(this.user.getEmail());
		System.out.println("+++++++++++++++++++++++++++++");
		Users user1 = new Users();
		user1.setName(name);
		user1.setPassword(password);
		user1.setSex(sex);
		user1.setEmail(email);
		user1.setType(type);
		userService.addUser(user1);// 获取登录用户
		System.out.println("*****************************");

		/*
		 * if(i==0){ System.out.println("BBBBBB"); this.addFieldError("error",
		 * "注册失败"); return "input"; //System.out.println("1");
		 * //this.addFieldError("error", "用户名或密码不正确，请重新输入！"); //return "login";
		 * }else {
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("name", name);// 将登录用户存储至Session中
		return "success";
	}

	public void validateAddUser() {
		System.out.println("进入增加用户校验方法");
		this.clearErrors();
		if (name == null) {
			this.addFieldError("name", "用户名不能为空");

		}
		if (password == null) {
			this.addFieldError("password", "密码不能为空");

		}
		if (email == null) {
			this.addFieldError("password", "邮箱不能为空");

		}

		if (name != null && !Pattern.matches("\\w{5,12}", name.trim())) {
			this.addFieldError("name", "您输入用户名必须是字母和数字，且长度必须是5到12位之间！");
		}
		// 如果密码不为空，且不匹配长度为4～25的字母和数字组成的字符串。
		if (password != null && !Pattern.matches("\\w{5,15}", password.trim())) {
			this.addFieldError("password", "您输入密码必须是字母和数字，且长度必须是5到15之间！");
		}
		if (!email
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {

			this.addFieldError("email", "邮箱不是一个合法邮箱！");

		}
	}

	public void validateUpDatePassword() {

		System.out.println("进入修改用户密码校验方法");
		this.clearErrors();

		if (password == null) {
			this.addFieldError("password", "密码不能为空");

		}
		if (rePassword == null) {
			this.addFieldError("rePassword", "重复密码不能为空");

		}

		// 如果密码不为空，且不匹配长度为4～25的字母和数字组成的字符串。
		if (password != null && !Pattern.matches("\\w{5,15}", password.trim())) {
			this.addFieldError("password", "您输入密码必须是字母和数字，且长度必须是5到15之间！");
		}
		if (rePassword != null
				&& !Pattern.matches("\\w{5,15}", rePassword.trim())) {
			this.addFieldError("rePassword", "您输入密码必须是字母和数字，且长度必须是5到15之间！");
		}

		if (password == (rePassword)) {

			this.addFieldError("rePassword", "两次输入的密码不一致");
		}

	}

}
