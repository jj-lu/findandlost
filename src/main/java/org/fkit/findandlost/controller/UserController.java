package org.fkit.findandlost.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fkit.findandlost.bean.FLUser;
import org.fkit.findandlost.service.UserService;
import org.fkit.findandlost.util.ResultCode;
import org.fkit.findandlost.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	private static Logger logger = LogManager.getLogger();
	
//	@RequestMapping("/findUser")
//	public String getUserList(Integer pageNum, Model model){
//		System.out.println("pagehelper"+pageNum);
//		PageHelper.startPage(pageNum, 6);
//		Page<User>  users= userService.findUser();
//		model.addAttribute("users",users);
//		return "admin";
//	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
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
	
	/**
	 * 注册用户
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping("/insertUser")
	@ResponseBody
	public String insertUser(@Valid FLUser user,BindingResult result) {
		logger.info("注册的用户："+user);
		for(ObjectError error : result.getAllErrors()) {
			return error.getDefaultMessage();
		}
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
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/updateUser")
	@ResponseBody
	public ResultVO<String> updateUser(@Valid FLUser user,BindingResult result) {
		//检测用户信息是否正确
		for(ObjectError error : result.getAllErrors()) {
			return new ResultVO<String>(ResultCode.VALIDATE_FAILED,error.getDefaultMessage());
		}		
		int i = userService.updateUser(user);
		if(i >= 1 ) {
			return new ResultVO<String>("更新用户成功");
		}else {
			return new ResultVO<String>("更新用户失败");
		}
	}
	
	/**
	 * 根据用户id查询用户（更新用户信息时使用）
	 * @param id
	 * @return
	 */
	@RequestMapping("/findUserById")
	@ResponseBody
	public ResultVO<FLUser> findUserById(Integer id) {
		System.out.println(userService.findUserById(id));
		return new ResultVO<FLUser>(userService.findUserById(id));
	}
	
	/**
	 * 页面搜索时使用
	 * @param user
	 * @param model
	 * @param pageNum
	 * @return
	 */
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
