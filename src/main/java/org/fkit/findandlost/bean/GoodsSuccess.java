package org.fkit.findandlost.bean;

public class GoodsSuccess {

	private String c_status;
	private int count;
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "GoodsSuccess [c_status=" + c_status + ", count=" + count + "]";
	}
	
}
