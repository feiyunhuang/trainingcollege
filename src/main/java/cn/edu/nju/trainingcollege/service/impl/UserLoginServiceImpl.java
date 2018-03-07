package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.service.UserLoginService;
import cn.edu.nju.trainingcollege.util.MD5Util;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final UserRepository userRepository;

    public UserLoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String mail, String password) {

        UserEntity userEntity = userRepository.findByMail(mail);
        if (userEntity != null&&userEntity.getPassword().equals(MD5Util.encode(password))) {
            return true;
        }
        else
            return false;
    }

}
