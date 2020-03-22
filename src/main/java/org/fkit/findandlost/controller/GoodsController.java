
package org.fkit.findandlost.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.fkit.findandlost.bean.Goods;
import org.fkit.findandlost.bean.GoodsData;
import org.fkit.findandlost.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	
	@RequestMapping("/findGoodsById")
	@ResponseBody
	public Goods findGoodsById(int id){
		Goods goods = goodsService.findGoodsById(id);
		System.out.println(goods);
		return goods;
	}
	
	/**
	 * 公告页面的图表数据
	 * @return
	 */
	@RequestMapping("/GoodsData")
    @ResponseBody
	public GoodsData GoodsData() {
		//System.out.println("goodsData");
		GoodsData gt = goodsService.getGoodsData();
		//System.out.println(gt.getLostTotal().isEmpty());
		return gt;
	}
	
	@RequestMapping("/findGoodsByg_status")
	public String findLostGoods(Goods good,Integer pageNum,Model model){
		System.out.println(good);
		PageHelper.startPage(pageNum, 6);
		Page<Goods> goods = goodsService.findGoodsByg_status(good);
		Iterator<Goods> it = goods.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		model.addAttribute("goods", goods);
		model.addAttribute("g_name", good.getG_name());
		model.addAttribute("g_type", good.getG_type());
		model.addAttribute("g_place", good.getG_place());
		model.addAttribute("c_status", good.getClassification().getC_status());
		model.addAttribute("c_type", good.getClassification().getC_type());
		return "goods";
	}
	
	@RequestMapping("/findGoods")
	public String findGoods(Goods good,Integer pageNum,Model model){
		System.out.println(good);
		System.out.println(pageNum);
		PageHelper.startPage(pageNum, 9);
		Page<Goods> goods = goodsService.findGoodsByg_status(good);
		Iterator<Goods> it = goods.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		model.addAttribute("goods", goods);
		model.addAttribute("g_ltime", good.getG_ltime());
		model.addAttribute("g_name", good.getG_name());
		model.addAttribute("g_type", good.getG_type());
		model.addAttribute("g_place", good.getG_place());
//		model.addAttribute("c_status", good.getClassification().getC_status());
		model.addAttribute("c_type", good.getClassification().getC_type());
		if(good.getClassification().getC_type().equals("寻物")) {
			model.addAttribute("title", "寻物启事信息列表");
		}else if(good.getClassification().getC_type().equals("招领")) {
			model.addAttribute("title", "招领启事信息列表");
		}
		
		return "notice";
	}
	
	
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public String deleteGoods(int id) {
		System.out.println(id);
		int i = goodsService.deleteGoods(id);
		if(i > 0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/updateGoods")
	@ResponseBody
	public String updateGoods(Goods goods,MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(goods);
		int i =  goodsService.updateGoods(file,goods);
		if(i > 0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/insertGoods")
	@ResponseBody
	public String insertGoods(MultipartFile file,Goods goods) throws IllegalStateException, IOException {
		System.out.println(goods);
		int i = goodsService.insertGoods(file,goods);
		if(i >= 1 ) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("detail")
	public String findGoodsToDetail(Integer id,Model model) {
		System.out.println(id);
		Goods goods = goodsService.findGoodsById(id);
		System.out.println(goods);
		model.addAttribute("goods", goods);
		return "detail"; 
	}
	
//		日期的转换类
	  @InitBinder
	    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        dateFormat.setLenient(false);
	        //	        可以输入空的日期参数
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }	
}
