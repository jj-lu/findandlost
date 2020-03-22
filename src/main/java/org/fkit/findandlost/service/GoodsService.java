package org.fkit.findandlost.service;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.fkit.findandlost.bean.Classification;
import org.fkit.findandlost.bean.FLUser;
import org.fkit.findandlost.bean.Goods;
import org.fkit.findandlost.bean.GoodsData;
import org.fkit.findandlost.bean.GoodsSuccess;
import org.fkit.findandlost.bean.GoodsType;
import org.fkit.findandlost.bean.RecentCount;
import org.fkit.findandlost.repository.ClassificationRepository;
import org.fkit.findandlost.repository.GoodsRepository;
import org.fkit.findandlost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;

@Service
public class GoodsService {
	private final static String path = "D:\\study\\JavaWeb\\findandlost\\src\\main\\resources\\static\\img";

	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private ClassificationRepository classificationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 添加失物信息，可以上传图片到img文件中
	 * @param file
	 * @param goods
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public int insertGoods(MultipartFile file,Goods goods) throws IllegalStateException, IOException {
		Timestamp rtime = new Timestamp(System.currentTimeMillis());
		goods.setG_rtime(rtime);
		Classification classification = goods.getClassification();
		if(classification.getC_id() == null) {
			classification.setC_id(classificationRepository.findC_id(classification));
			goods.setClassification(classification);
		}	
		FLUser user = goods.getUser();
		if(user.getU_id() == null) {
			user.setU_id(userRepository.findU_id(user));
			goods.setUser(user);
		}
		if(!file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			//应该放在Tomcat的容器里，为了可以方便同时导出项目和图片放在img文件夹中
			File filepath = new File(path,file.getOriginalFilename());
			System.out.println(filepath);
			if(!filepath.getParentFile().exists()) {
				filepath.mkdir();
			}
			file.transferTo(filepath);
			goods.setG_picture(file.getOriginalFilename());
		}
		return goodsRepository.insertGoods(goods);
	}
	
	/**
	 * 删除物品信息
	 * @param id
	 * @return
	 */
	public int deleteGoods(int id) {
		return goodsRepository.deleteGoods(id);
	}
	
	/**
	 * 获取公告页面的所有图表数据
	 * @return
	 */
	public GoodsData getGoodsData() {
		GoodsData goodsData = new GoodsData();
		//获得丢失物品各种类型的数量
		List<GoodsType> goodsType = goodsRepository.statisticsGoodsType("寻物");
		List<GoodsSuccess> findSuccess = goodsRepository.statisticsGoodsSuccess("寻物");
		List<GoodsSuccess> returnSuccess = goodsRepository.statisticsGoodsSuccess("招领");
		List<RecentCount> recentLost = goodsRepository.statisticsRecentCount("寻物");
		goodsData.setLosttotal(goodsType);
		goodsData.setRecentLost(recentLost);
		goodsData.setFindDatas(findSuccess);
		goodsData.setReturnDatas(returnSuccess);
//		goodsData.setFindJSON(findSuccess);
//		goodsData.setReturnJSON(returnSuccess);
		return goodsData;
	}
	
	
	//warm
	public int updateGoods(MultipartFile file,Goods goods) throws IllegalStateException, IOException {
		Timestamp rtime = new Timestamp(System.currentTimeMillis());
		goods.setG_rtime(rtime);
		Classification classification = goods.getClassification();
		//java.lang.NullPointerException: null
		//at org.fkit.findandlost.service.GoodsService.updateGoods(GoodsService.java:69) ~[classes/:na]
		if(classification.getC_id() == null) {
			classification.setC_id(classificationRepository.findC_id(classification));
			goods.setClassification(classification);
		}
		FLUser user = goods.getUser();
		if(user.getU_id() == null) {
			user.setU_id(userRepository.findU_id(user));
			goods.setUser(user);
		}
		if(!file.isEmpty()) {
			System.out.println(file.getOriginalFilename());
			//应该放在Tomcat的容器里，为了可以方便同时导出项目和图片放在img文件夹中
			File filepath = new File(path,file.getOriginalFilename());
			System.out.println(filepath);
			if(!filepath.getParentFile().exists()) {
				filepath.mkdir();
			}
			file.transferTo(filepath);
			goods.setG_picture(file.getOriginalFilename());
		}
		return goodsRepository.updateGoods(goods);
	}
	
	/**
	 * 根据物品id查询物品具体信息
	 * @param id
	 * @return
	 */
	public Goods findGoodsById(int id){
		return goodsRepository.findGoodsById(id);
	}
	
	/**
	 * 按物品状态查询物品列表，可进行分页
	 * @param goods
	 * @return
	 */
	public Page<Goods> findGoodsByg_status(Goods goods){
		return goodsRepository.findGoodsByg_status(goods);
	}
	
	/**
	 * 根据用户id查询该用户发布的物品信息
	 * @param id
	 * @return
	 */
	public List<Goods> findGoodsByUser(Integer id){
		return goodsRepository.findGoodsByUser(id);
	}
}
