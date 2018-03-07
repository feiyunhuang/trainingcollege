package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.service.StudentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentRegisterServiceImpl implements StudentRegisterService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;

    @Autowired
    public StudentRegisterServiceImpl(UserInfoRepository userInfoRepository, UserRepository userRepository) {
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
    }

    public void save(String mail,String password,String name) {

        UserEntity userEntity = new UserEntity();
        userEntity.setMail(mail);
        userEntity.setPassword(password);

        userEntity = userRepository.save(userEntity);
        int id=userEntity.getId();

        UserInfoEntity userInfoEntity=new UserInfoEntity();
        userInfoEntity.setId(id);
        userInfoEntity.setName(name);
        userInfoEntity=userInfoRepository.save(userInfoEntity);

    }
}
