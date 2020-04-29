package org.fkit.findandlost.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Goods {

	private Integer g_id;	
	@NotBlank(message = "请填写物品名称")
	private String g_name;
	
	private String g_type;
	
	@NotNull(message = "请填写完整物品的丢失时间")
	private Date g_ltime;
	
	@NotBlank(message = "请填写失物大概丢失的位置")
	private String g_place;
	
	private String g_picture;
	private Timestamp g_rtime;
	
	@NotBlank(message = "请填写启示标题")
	private String g_title;
	
	@NotBlank(message = "请填写物品描述信息")
	private String g_describe;
	
	@NotBlank(message = "请填写物品关键信息")
	private String g_key;

	private FLUser user;
	private Classification classification;
	private List<Message> message;
	public Integer getG_id() {
		return g_id;
	}
	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public Date getG_ltime() {
		return g_ltime;
	}
	public void setG_ltime(Date g_ltime) {
		this.g_ltime = g_ltime;
	}
	public String getG_place() {
		return g_place;
	}
	public void setG_place(String g_place) {
		this.g_place = g_place;
	}
	public String getG_picture() {
		return g_picture;
	}
	public void setG_picture(String g_picture) {
		this.g_picture = g_picture;
	}
	public Timestamp getG_rtime() {
		return g_rtime;
	}
	public void setG_rtime(Timestamp g_rtime) {
		this.g_rtime = g_rtime;
	}
	public String getG_title() {
		return g_title;
	}
	public void setG_title(String g_title) {
		this.g_title = g_title;
	}
	public String getG_describe() {
		return g_describe;
	}
	public void setG_describe(String g_describe) {
		this.g_describe = g_describe;
	}
	public String getG_key() {
		return g_key;
	}
	public void setG_key(String g_key) {
		this.g_key = g_key;
	}
	public FLUser getUser() {
		return user;
	}
	public void setUser(FLUser user) {
		this.user = user;
	}
	public Classification getClassification() {
		return classification;
	}
	public void setClassification(Classification classification) {
		this.classification = classification;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Goods [g_id=" + g_id + ", g_name=" + g_name + ", g_type=" + g_type + ", g_ltime=" + g_ltime
				+ ", g_place=" + g_place + ", g_picture=" + g_picture + ", g_rtime=" + g_rtime + ", g_title=" + g_title
				+ ", g_describe=" + g_describe + ", g_key=" + g_key + ", user=" + user + ", classification="
				+ classification + ", message=" + message + "]";
	}
	
	
	
}
