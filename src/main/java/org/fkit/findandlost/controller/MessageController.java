package org.fkit.findandlost.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fkit.findandlost.bean.Message;
import org.fkit.findandlost.service.MessageService;
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
public class MessageController {
	
	private Logger logger = LogManager.getLogger(MessageController.class);
	
	@Autowired
	private MessageService messageService;

	@RequestMapping("/insertMessage")
	@ResponseBody
	public String insertMessage(@Valid Message message,BindingResult result) {
		//
		for(ObjectError error : result.getAllErrors()) {
			logger.info("错误信息："+error.getDefaultMessage());
			return error.getDefaultMessage();
		}
		int i = messageService.insertMessage(message);
		if(i > 0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/deleteMessage")
	@ResponseBody
	public String deleteMessage(int id) {
		int i = messageService.deleteMessage(id);
		if(i>0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/updateMessage")
	@ResponseBody
	public String updateMessage(@Valid Message message,BindingResult result) {
		for(ObjectError error : result.getAllErrors()) {
			logger.info("错误信息："+error.getDefaultMessage());
			return error.getDefaultMessage();
		}
		int i = messageService.updateMessage(message);
		if(i > 0) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/findMessageById")
	@ResponseBody
	public Message findMessageById(int id) {
		Message message = messageService.findMessageById(id);
		System.out.println(message);
		return message;
	}
	
	@RequestMapping("/findMessageBy")
	public String findMessageBy(Message message,Model model,Integer pageNum) {
		System.out.println(message);
		PageHelper.startPage(pageNum, 6);
		Page<Message> messages = messageService.findMessageBy(message);
		model.addAttribute("messages", messages);
		model.addAttribute("loginname", message.getUser().getLoginname());
		model.addAttribute("g_name", message.getGoods().getG_name());
		//model.addAttribute("m_rtime", message.getM_rtime());
		Iterator<Message> it = messages.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		return "message";
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
