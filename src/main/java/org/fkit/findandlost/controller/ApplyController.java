package org.fkit.findandlost.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fkit.findandlost.bean.Apply;
import org.fkit.findandlost.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class ApplyController {
	
	private Logger logger = LogManager.getLogger(ApplyController.class);
	
	@Autowired
	private ApplyService applyService;

	@RequestMapping("/insertApply")
	@ResponseBody
	public String insertApply(@Valid Apply apply,BindingResult result) {
		for(ObjectError error : result.getAllErrors()) {
			logger.info("错误信息："+error.getDefaultMessage());
			return error.getDefaultMessage();
		}
		int i = applyService.insertApply(apply);
		if(i > 0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/deleteApply")
	@ResponseBody
	public String deleteApply(int id) {
		int i = applyService.deleteApply(id);
		if(i>0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/updateApply")
	@ResponseBody
	public String updateApply(@Valid Apply apply,BindingResult result) {
		for(ObjectError error : result.getAllErrors()) {
			logger.info("错误信息："+error.getDefaultMessage());
			return error.getDefaultMessage();
		}
		int i = applyService.updateApply(apply);
		if(i > 0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/checkApply")
	@ResponseBody
	public String checkApply(Apply apply) {
		int i = applyService.checkApply(apply);
		if(i>0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/findApplyById")
	@ResponseBody
	public Apply findApplyeById(int id) {
		Apply apply = applyService.findApplyById(id);
		System.out.println(apply);
		return apply;
	}
	
	@RequestMapping("/findApplyBy")
	public String findApplyBy(Apply apply,Model model,Integer pageNum) {
		System.out.println(apply);
		PageHelper.startPage(pageNum, 6);
		Page<Apply> applys = applyService.findApplyBy(apply);
		model.addAttribute("applys", applys);
		model.addAttribute("username", apply.getUser().getUsername());
		model.addAttribute("g_name", apply.getGoods().getG_name());
		model.addAttribute("a_status", apply.getA_status());
		//model.addAttribute("m_rtime", message.getM_rtime());
		Iterator<Apply> it = applys.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		return "apply";
	}
	
//	日期的转换类
  @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //	        可以输入空的日期参数
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }	
}
