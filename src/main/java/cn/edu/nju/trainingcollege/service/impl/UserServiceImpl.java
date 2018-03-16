package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.*;
import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.UserService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.util.MD5Util;
import cn.edu.nju.trainingcollege.vo.ClassInfoVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final MailService mailService;
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public UserServiceImpl(UserInfoRepository userInfoRepository, UserRepository userRepository, MemberRepository memberRepository, MailService mailService, ClassRepository classRepository, TeacherRepository teacherRepository, SchoolRepository schoolRepository) {
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
        this.schoolRepository = schoolRepository;
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
        MemberInfoVo memberInfoVo=new MemberInfoVo(id,memberEntity.getPoint(),memberEntity.getLevel(),memberEntity.getAccumulate(),helper.timeToDateString(userInfoEntity.getRegistdate()),""+helper.getDiscount(memberEntity.getAccumulate()),userInfoEntity.getName(),memberEntity.getCoupon());
        return  memberInfoVo;
    }

    @Override
    public ClassInfoVo getClassInfo(int id) {

        ClassEntity classEntity= classRepository.getOne(id);
        TeacherEntity teacherEntity=teacherRepository.getOne(classEntity.getTeacherid());
        SchoolEntity schoolEntity=schoolRepository.getOne(classEntity.getSchoolid());

        Helper helper=new Helper();

        ClassInfoVo classInfoVo=new ClassInfoVo();

        classInfoVo.setId(classEntity.getId());
        classInfoVo.setName(classEntity.getName());
        classInfoVo.setSchoolname(schoolEntity.getName());
        classInfoVo.setTeachername(teacherEntity.getName());
        classInfoVo.setTimeaweek(helper.daytostr(classEntity.getTimeaweek()));
        classInfoVo.setWeek(classEntity.getWeek());
        classInfoVo.setClassnum(classEntity.getClassnum());
        classInfoVo.setStudentaclass(classEntity.getStudentaclass());
        classInfoVo.setPrice(classEntity.getPrice());
        classInfoVo.setDaytime(classEntity.getDaytime());
        classInfoVo.setBegintime(helper.timeToDateString(classEntity.getBegindate()));
        classInfoVo.setRegistdate(helper.timeToDateString(classEntity.getRegistdate()));
        classInfoVo.setDescription(classEntity.getDescription());
        classInfoVo.setTeacherdescription(teacherEntity.getDescription());

        return classInfoVo;
    }

    @Override
    public OrderVo generateorder(int classid, int userid) {
        ClassEntity classEntity= classRepository.getOne(classid);
        MemberEntity memberEntity=memberRepository.getOne(userid);
        UserInfoEntity userInfoEntity=userInfoRepository.getOne(userid);

        Helper helper=new Helper();
        OrderVo order=new OrderVo();
        order.setClassname(classEntity.getName());
        order.setPrice(classEntity.getPrice());
        order.setMemberid(userid);
        order.setMemberlevel(memberEntity.getLevel());
        order.setDiscount(helper.getDiscount(memberEntity.getAccumulate()));
        order.setPhone(userInfoEntity.getPhonenum());
        order.setCoupon(memberEntity.getCoupon());

        return order;
    }


}
