package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.MemberRepository;
import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.MemberEntity;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.UserRegisterService;
import cn.edu.nju.trainingcollege.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final MailService mailService;

    @Autowired
    public UserRegisterServiceImpl(UserInfoRepository userInfoRepository, UserRepository userRepository, MemberRepository memberRepository, MailService mailService) {
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.mailService = mailService;
    }

    public void register(String mail, String password, String name,String phone,String sex) {


        mailService.send(mail,"trainingcollege","您好,"+name+",恭喜你注册成功,"+"您的密码是"+password+",请牢记");
        UserEntity userEntity = new UserEntity();
        userEntity.setMail(mail);
        userEntity.setPassword(MD5Util.encode(password));

        userEntity = userRepository.save(userEntity);
        int id = userEntity.getId();

        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(id);
        userInfoEntity.setName(name);
        userInfoEntity.setPhonenum(phone);
        userInfoEntity.setSex(sex);
        userInfoEntity = userInfoRepository.save(userInfoEntity);

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(id);
        memberEntity = memberRepository.save(memberEntity);

    }

}
