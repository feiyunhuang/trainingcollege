package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.MemberRepository;
import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.MemberEntity;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.UserService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.util.MD5Util;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final MailService mailService;

    @Autowired
    public UserServiceImpl(UserInfoRepository userInfoRepository, UserRepository userRepository, MemberRepository memberRepository, MailService mailService) {
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

    @Override
    public UserEntity findByMail(String mail) {

        return userRepository.findByMail(mail);
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

    @Override
    public UserInfoEntity getUserInfoById(int id) {
        return userInfoRepository.getOne(id);
    }

    @Override
    public MemberInfoVo getMemberInfo(int id) {
        UserInfoEntity userInfoEntity=userInfoRepository.getOne(id);
        MemberEntity memberEntity=memberRepository.getOne(id);
        Helper helper=new Helper();
        MemberInfoVo memberInfoVo=new MemberInfoVo(id,memberEntity.getPoint(),memberEntity.getLevel(),memberEntity.getAccumulate(),helper.timeToDateString(userInfoEntity.getRegistdate()),""+helper.getDiscount(memberEntity.getAccumulate()),userInfoEntity.getName());
        return  memberInfoVo;
    }


}
