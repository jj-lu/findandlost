package org.fkit.findandlost.bean;

public class RecentCount {

	private String g_ltime;
	private int count;
	public String getG_ltime() {
		return g_ltime;
	}
	public void setG_ltime(String g_ltime) {
		this.g_ltime = g_ltime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "RecentCount [g_ltime=" + g_ltime + ", count=" + count + "]";
	}
	
	
}
