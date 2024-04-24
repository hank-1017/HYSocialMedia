package com.hung1.esunbank_back.service;

import com.hung1.esunbank_back.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hung1.esunbank_back.model.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	@Autowired
	private UserRepository usersRepo;
	
	public User addUser(User user) {
		String encodedPwd = pwdEncoder.encode(user.getPwd());   // 加密
		user.setPwd(encodedPwd);
		return usersRepo.save(user);
	}
	
	public boolean checkIfUsernameExist(String username) {
		
		User dbUser = usersRepo.findByUserName(username);
		
		if(dbUser != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public User checkLogin(String username, String inputPwd) {
		User dbUser = usersRepo.findByUserName(username);
		
		if(dbUser != null) {
			                     // (要去比對的, 加密過後的)
			if(pwdEncoder.matches(inputPwd, dbUser.getPwd())) {
				return dbUser;
			}
		}
		
		return null;
	}

}
