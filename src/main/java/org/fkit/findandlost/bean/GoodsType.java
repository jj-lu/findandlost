package org.fkit.findandlost.bean;

public class GoodsType {

	//物品类型
	private String g_type;
	//物品总数
	private Integer count;
	
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "GoodsType [g_type=" + g_type + ", count=" + count + "]";
	}
	
	
	
}
