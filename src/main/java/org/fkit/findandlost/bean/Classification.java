package org.fkit.findandlost.bean;

import java.util.List;

public class Classification {

	private Integer c_id;
	private String c_type;
	private String c_status;
	private List<Goods> goods;
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "Classification [c_id=" + c_id + ", c_type=" + c_type + ", c_status=" + c_status + ", goods=" + goods
				+ "]";
	}
	
	
	
}
