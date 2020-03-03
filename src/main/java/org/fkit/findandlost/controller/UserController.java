package org.fkit.findandlost.controller;

import javax.servlet.http.HttpSession;

import org.fkit.findandlost.bean.FLUser;
import org.fkit.findandlost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
//	@RequestMapping("/findUser")
//	public String getUserList(Integer pageNum, Model model){
//		System.out.println("pagehelper"+pageNum);
//		PageHelper.startPage(pageNum, 6);
//		Page<User>  users= userService.findUser();
//		model.addAttribute("users",users);
//		return "admin";
//	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(int id) {
		System.out.println(id);
		int i = userService.deleteUser(id);
		if(i >= 1 ) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public String insertUser(FLUser user) {
		System.out.println(user);
		int i = userService.insertUser(user);
		if(i >= 1 ) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(FLUser user,HttpSession session) {
		System.out.println(user);
		FLUser u = userService.findUserByLogin(user);
		if(u != null) {
			System.out.println(user);
			session.setAttribute("USER_SESSION", u);
			if(u.getRole().equals("ROLE_ADMIN")) {
				System.out.println("admin");
				return "admin";
			}else{
				System.out.println("user");
				return "user";
			}
		}
		System.out.println("false");
		return "false";
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(FLUser user) {
		System.out.println(user);
		int i = userService.updateUser(user);
		if(i >= 1 ) {
			return "OK";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/findUserById")
	@ResponseBody
	public FLUser findUserById(Integer id) {
		System.out.println(userService.findUserById(id));
		return userService.findUserById(id);
	}
	
	@RequestMapping("/findUserBy")
	public String findUserBy(FLUser user,Model model,Integer pageNum){
		System.out.println("search:"+user+pageNum);
		PageHelper.startPage(pageNum, 6);
		Page<FLUser> users = userService.findUserBy(user);
		model.addAttribute("users", users);
		model.addAttribute("username", user.getUsername());
		model.addAttribute("clazz", user.getClazz());
		model.addAttribute("sex", user.getSex());
		return "user";
	}
}
