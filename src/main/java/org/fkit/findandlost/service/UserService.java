package org.fkit.findandlost.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fkit.findandlost.bean.FLUser;
import org.fkit.findandlost.repository.UserRepository;
import org.fkit.findandlost.util.MD5util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

@Service
public class UserService {
	
	private static Logger logger = LogManager.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	public int findU_id(FLUser user) {
		return userRepository.findU_id(user);
	}
	
	/**
	 * 注册用户方法
	 * @param user
	 * @return
	 */
	public int insertUser(FLUser user) {
		//转换位MD5密钥
		String password = MD5util.code(user.getPassword());
		logger.info("加密后的密钥："+password);
				
		//重置密码
		user.setPassword(password);
		return userRepository.insertUser(user);
	}
	
	public int deleteUser(int id) {
		return userRepository.deleteUser(id);
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(FLUser user) {
		//转换位MD5密钥
		String password = MD5util.code(user.getPassword());
		logger.info("加密后的密钥："+password);
				
		//重置密码
		user.setPassword(password);
		return userRepository.updateUser(user);
	}
	
	/**
	 * 根据用户id查找用户信息
	 * @param id
	 * @return
	 */
	public FLUser findUserById(Integer id) {
		FLUser user = userRepository.findUserById(id);
		return user;
	}
	
//	public Page<User> findUser(){
//		return userRepository.findUser();
//	}
	
	public Page<FLUser> findUserBy(FLUser user){
		return userRepository.findUserBy(user);
	}
	
	/**
	 * 检测用户登录方法
	 * @param user
	 * @return
	 */
	public FLUser findUserByLogin(FLUser user) {
		//转换位MD5密钥
		String password = MD5util.code(user.getPassword());
		logger.info("加密后的密钥："+password);
		
		//重置密码
		user.setPassword(password);
		return userRepository.findUserByLogin(user);
	}
	
//	public FLUser findUserAll(int id) {
//		return userRepository.findUserAll(id);
//	}

//	@Override
//	public UserDetails loadUserByUsername(String loginname) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		FLUser flUser = userRepository.findUserByLoginname(loginname);
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(flUser.getRole()));
//		return new User(flUser.getUsername(),flUser.getPassword(),authorities);
//	}
}
