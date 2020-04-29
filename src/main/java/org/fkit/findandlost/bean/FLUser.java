package org.fkit.findandlost.bean;

import java.util.List;

import javax.validation.constraints.NotBlank;

/**
 * 用户信息
 * @author JJ
 *
 */
public class FLUser {

	//用户Id
	private Integer u_id;
	
	//登录名
	@NotBlank
	private String loginname;
	
	//用户名
	@NotBlank
	
	private String username;
	private String password;
	private String email;
	private String phone;
	private String qq;
	private String idcard;
	private Character sex;
	private String clazz;
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
