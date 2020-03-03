package org.fkit.findandlost.service;

import org.fkit.findandlost.bean.FLUser;
import org.fkit.findandlost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public int findU_id(FLUser user) {
		return userRepository.findU_id(user);
	}
	
	public int insertUser(FLUser user) {
		return userRepository.insertUser(user);
	}
	
	public int deleteUser(int id) {
		return userRepository.deleteUser(id);
	}
	
	public int updateUser(FLUser user) {
		return userRepository.updateUser(user);
	}
	
	
	public FLUser findUserById(Integer id) {
		return userRepository.findUserById(id);
	}
	
//	public Page<User> findUser(){
//		return userRepository.findUser();
//	}
	
	public Page<FLUser> findUserBy(FLUser user){
		return userRepository.findUserBy(user);
	}
	
	public FLUser findUserByLogin(FLUser user) {
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
