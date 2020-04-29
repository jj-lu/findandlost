package org.fkit.findandlost.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

/**
 * 申请信息
 * @author JJ
 *
 */
public class Apply {

	private Integer a_id;
//	private Integer u_id;
//	private Integer g_id;
	private String a_status;
	private Timestamp a_rtime;
	@NotBlank
	private String a_key;
	private FLUser user;
	private Goods goods;
	public Integer getA_id() {
		return a_id;
	}
	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}
	public String getA_status() {
		return a_status;
	}
	public void setA_status(String a_status) {
		this.a_status = a_status;
	}
	public Timestamp getA_rtime() {
		return a_rtime;
	}
	public void setA_rtime(Timestamp a_rtime) {
		this.a_rtime = a_rtime;
	}
	public String getA_key() {
		return a_key;
	}
	public void setA_key(String a_key) {
		this.a_key = a_key;
	}
	public FLUser getUser() {
		return user;
	}
	public void setUser(FLUser user) {
		this.user = user;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Apply [a_id=" + a_id + ", a_status=" + a_status + ", a_rtime=" + a_rtime + ", a_key=" + a_key
				+ ", user=" + user + ", goods=" + goods + "]";
	}
	
	
}
