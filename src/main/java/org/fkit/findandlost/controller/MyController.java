package org.fkit.findandlost.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.fkit.findandlost.bean.Apply;
import org.fkit.findandlost.bean.FLUser;
import org.fkit.findandlost.bean.Goods;
import org.fkit.findandlost.bean.Message;
import org.fkit.findandlost.service.ApplyService;
import org.fkit.findandlost.service.GoodsService;
import org.fkit.findandlost.service.MessageService;
import org.fkit.findandlost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;

@Controller
public class MyController {

	@Autowired
	private UserService userService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private ApplyService applyService;

	@Autowired
	private MessageService messageService;

	@RequestMapping("logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

	@RequestMapping(value = "/index")
	public String toIndex() {
		return "index";
	}

	@RequestMapping(value = "/")
	public String Index() {
		return "index";
	}

	@RequestMapping("/admin")
	public String toAdmin() {
		return "admin";
	}

	@RequestMapping("/home")
	public String toHome(int id, Model model) {
		FLUser user = userService.findUserById(id);
		model.addAttribute("user", user);
		List<Goods> goodses = goodsService.findGoodsByUser(id);
		model.addAttribute("goodses", goodses);
//		List<Apply> applyes = applyService.findApplyByUser(id);
		Apply apply = new Apply();
		Goods goods = new Goods();
		apply.setUser(user);
		apply.setGoods(goods);
		Page<Apply> applyes = applyService.findApplyBy(apply);
		model.addAttribute("applyes", applyes);
//		List<Message> messages = messageService.findMessageByUser(id);
		Message message = new Message();
		message.setUser(user);
		message.setGoods(goods);
		Page<Message> messages = messageService.findMessageBy(message);
		model.addAttribute("messages", messages);
		return "home";
	}

}
