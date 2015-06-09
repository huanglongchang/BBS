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
		System.out.println("�����������Action");
		userService.upDatePassword(name, password);
		return "success";

	}
	

	
	
	 public void getUserByName(){
		 user = userService.getUserByName(name);
		 System.out.println("++++++++++++++++++++++++++++++++++++++");
		 System.out.println(user.getName());
		 HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", user);// ����¼�û��洢��Session��	 
	 }

	 
	public String login() {
		System.out.println("=============================");
		user = userService.getLogin(name, password);

		if (user != null) {
			System.out.println("+++++++++++++++++++++++++++++++");
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("name", name);// ����¼�û��洢��Session��
			return "success";
		} else {
			System.out.println("-------------------------------");
			this.addFieldError("name", "�û��������벻��ȷ��");
			return "input";
		}
	}

	public void validateLogin() {

		System.out.println("�����û���¼У�鷽��");
		this.clearErrors();

		/*
		 * if(name==null){ this.addFieldError("name" , "�û�������Ϊ��");
		 * System.out.println("OK3"); } if(password==null){
		 * this.addFieldError("password" , "���벻��Ϊ��"); System.out.println("OK3");
		 * }
		 */
		if (name == null || "".equals(name.trim())) {
			this.addFieldError("name", "�û�������Ϊ�գ�");
		}
		/*
		 * if
		 * (!Pattern.compile("^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$").matcher(
		 * username.trim()).matches()) { this.addFieldError("username",
		 * "�û������ȱ�����5-20֮�䣬������ĸ��ͷ���ɴ����֡�_��.���ַ�����"); }
		 */
		if (password == null || "".equals(password.trim())) {
			this.addFieldError("password", "���벻��Ϊ�գ�");
		}

	}

	public String addUser() {
		// System.out.println(name+" "+password);
		// user=null;
		if (sex == "1") {
			sex = "��";
		} else {
			sex = "Ů";
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
		userService.addUser(user1);// ��ȡ��¼�û�
		System.out.println("*****************************");

		/*
		 * if(i==0){ System.out.println("BBBBBB"); this.addFieldError("error",
		 * "ע��ʧ��"); return "input"; //System.out.println("1");
		 * //this.addFieldError("error", "�û��������벻��ȷ�����������룡"); //return "login";
		 * }else {
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("name", name);// ����¼�û��洢��Session��
		return "success";
	}

	public void validateAddUser() {
		System.out.println("���������û�У�鷽��");
		this.clearErrors();
		if (name == null) {
			this.addFieldError("name", "�û�������Ϊ��");

		}
		if (password == null) {
			this.addFieldError("password", "���벻��Ϊ��");

		}
		if (email == null) {
			this.addFieldError("password", "���䲻��Ϊ��");

		}

		if (name != null && !Pattern.matches("\\w{5,12}", name.trim())) {
			this.addFieldError("name", "�������û�����������ĸ�����֣��ҳ��ȱ�����5��12λ֮�䣡");
		}
		// ������벻Ϊ�գ��Ҳ�ƥ�䳤��Ϊ4��25����ĸ��������ɵ��ַ�����
		if (password != null && !Pattern.matches("\\w{5,15}", password.trim())) {
			this.addFieldError("password", "�����������������ĸ�����֣��ҳ��ȱ�����5��15֮�䣡");
		}
		if (!email
				.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {

			this.addFieldError("email", "���䲻��һ���Ϸ����䣡");

		}
	}

	public void validateUpDatePassword() {

		System.out.println("�����޸��û�����У�鷽��");
		this.clearErrors();

		if (password == null) {
			this.addFieldError("password", "���벻��Ϊ��");

		}
		if (rePassword == null) {
			this.addFieldError("rePassword", "�ظ����벻��Ϊ��");

		}

		// ������벻Ϊ�գ��Ҳ�ƥ�䳤��Ϊ4��25����ĸ��������ɵ��ַ�����
		if (password != null && !Pattern.matches("\\w{5,15}", password.trim())) {
			this.addFieldError("password", "�����������������ĸ�����֣��ҳ��ȱ�����5��15֮�䣡");
		}
		if (rePassword != null
				&& !Pattern.matches("\\w{5,15}", rePassword.trim())) {
			this.addFieldError("rePassword", "�����������������ĸ�����֣��ҳ��ȱ�����5��15֮�䣡");
		}

		if (password == (rePassword)) {

			this.addFieldError("rePassword", "������������벻һ��");
		}

	}

}
