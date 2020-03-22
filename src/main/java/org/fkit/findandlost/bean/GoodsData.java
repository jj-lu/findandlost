package org.fkit.findandlost.bean;

import java.util.List;

public class GoodsData {

	//丢失物品的类型数量
	private List<GoodsType> losttotal;
	//成功归还物品
	private List<GoodsSuccess> returnDatas;
	//成功找到物
	private List<GoodsSuccess> findDatas;
	//近一周丢失物品的数量
	private List<RecentCount> recentLost;
	public List<GoodsType> getLosttotal() {
		return losttotal;
	}
	public void setLosttotal(List<GoodsType> losttotal) {
		this.losttotal = losttotal;
	}
	public List<GoodsSuccess> getReturnDatas() {
		return returnDatas;
	}
	public void setReturnDatas(List<GoodsSuccess> returnDatas) {
		this.returnDatas = returnDatas;
	}
	public List<GoodsSuccess> getFindDatas() {
		return findDatas;
	}
	public void setFindDatas(List<GoodsSuccess> findDatas) {
		this.findDatas = findDatas;
	}
	public List<RecentCount> getRecentLost() {
		return recentLost;
	}
	public void setRecentLost(List<RecentCount> recentLost) {
		this.recentLost = recentLost;
	}
	
}
