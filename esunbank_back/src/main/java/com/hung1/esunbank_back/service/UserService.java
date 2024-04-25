package com.hung1.esunbank_back.service;

import com.hung1.esunbank_back.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hung1.esunbank_back.model.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder pwdEncoder;

    @Autowired
    private UserRepository usersRepo;

    @Transactional
    public User addUser(String username, String pwd, String email, String biography) {
        User u1 = new User();
        u1.setUserName(username);
        u1.setEmail(email);
        u1.setPwd(pwd);
        u1.setBiography(biography);

        String encodedPwd = pwdEncoder.encode(u1.getPwd());   // 加密
        u1.setPwd(encodedPwd);
        return usersRepo.save(u1);
    }

    public boolean checkIfUsernameExist(String username) {

        User dbUser = usersRepo.findByUserName(username);

        if (dbUser != null) {
            return true;
        } else {
            return false;
        }
    }

    public User checkLogin(String username, String inputPwd) {
        User dbUser = usersRepo.findByUserName(username);

        if (dbUser != null) {
            // (要去比對的, 加密過後的)
            if (pwdEncoder.matches(inputPwd, dbUser.getPwd())) {
                return dbUser;
            }
        }

        return null;
    }

}
