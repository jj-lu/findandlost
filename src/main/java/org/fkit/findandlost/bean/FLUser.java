package org.fkit.findandlost.bean;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户信息
 * @author JJ
 *
 */
public class FLUser {

	//用户Id
	private Integer u_id;
	
	//登录名
	@NotBlank(message = "登录名不能为空")
	private String loginname;
	
	//用户名
	@NotBlank(message = "用户名不能为空")
	@Size(min = 2,max = 10,message="用户名长度必须是2-10个字符")
	private String username;
	
	//密码
	@NotBlank(message = "密码不能为空")
	@Size(min = 6,max = 18,message="密码长度必须是6-18个字符")
	private String password;
	
	//电子邮箱
	@Email(message = "邮箱地址不能为空")
	@NotBlank(message = "请输入正确的邮箱信息")
	private String email;
	
	//联系电话
	@NotBlank(message = "联系电话不能为空")
	@Pattern(regexp = "\\d{11}$",message = "联系电话必须位11位号码")
	private String phone;
	
	//QQ号码
	@Pattern(regexp = "[1-9][0-9]{4,14}",message = "请输入正确的QQ")
	private String qq;
	
	//身份证
	@NotBlank(message = "身份证信息不能为空")
	@Pattern(regexp = "\\d{18}$",message = "输入正确的18位身份证号码")
	private String idcard;
	
	//性别
	private Character sex;
	
	//班级
	private String clazz;
	
	//用户权限
	private String role;
	private List<Goods> goodses;
	private List<Apply> applys;
	private List<Message> messages;
	
	public List<Apply> getApplys() {
		return applys;
	}
	public void setApplys(List<Apply> applys) {
		this.applys = applys;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Goods> getGoods() {
		return goodses;
	}
	public void setGoods(List<Goods> goods) {
		this.goodses = goods;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", loginname=" + loginname + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + ", qq=" + qq + ", idcard=" + idcard + ", sex=" + sex
				+ ", clazz=" + clazz + ", role=" + role + ", goods=" + goodses + "]";
	}
		

	
}
