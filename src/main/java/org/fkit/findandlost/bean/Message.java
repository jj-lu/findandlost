package org.fkit.findandlost.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

public class Message {

	private Integer m_id;
	
	@NotBlank(message = "发布留言不能为空")
	private String message;
	private Timestamp m_rtime;
	private Integer g_id;
	private Integer u_id;
	private Goods goods;
	private FLUser user;
	public Integer getM_id() {
		return m_id;
	}
	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getM_rtime() {
		return m_rtime;
	}
	public void setM_rtime(Timestamp m_rtime) {
		this.m_rtime = m_rtime;
	}
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public FLUser getUser() {
		return user;
	}
	public void setUser(FLUser user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Message [m_id=" + m_id + ", message=" + message + ", m_rtime=" + m_rtime + ", g_id=" + g_id + ", u_id="
				+ u_id + ", goods=" + goods + ", user=" + user + "]";
	}
	
}
