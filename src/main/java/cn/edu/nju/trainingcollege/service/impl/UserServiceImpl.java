package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.*;
import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.entity.constant.MemberState;
import cn.edu.nju.trainingcollege.entity.constant.OrderState;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.UserService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.util.MD5Util;
import cn.edu.nju.trainingcollege.vo.ClassInfoVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;
    private final MailService mailService;
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;
    private final SchoolRepository schoolRepository;
    private final OrderRepository orderRepository;
    private final BankRepository bankRepository;
    private final ClassAndLabelRepository classAndLabelRepository;
    private final AllocateClassRepository allocateClassRepository;
    private final MarkRepository markRepository;

    @Autowired
    public UserServiceImpl(UserInfoRepository userInfoRepository, UserRepository userRepository, MemberRepository memberRepository, MailService mailService, ClassRepository classRepository, TeacherRepository teacherRepository, SchoolRepository schoolRepository, OrderRepository orderRepository, BankRepository bankRepository, ClassAndLabelRepository classAndLabelRepository, AllocateClassRepository allocateClassRepository, MarkRepository markRepository) {
        this.userInfoRepository = userInfoRepository;
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
        this.schoolRepository = schoolRepository;
        this.orderRepository = orderRepository;
        this.bankRepository = bankRepository;
        this.classAndLabelRepository = classAndLabelRepository;
        this.allocateClassRepository = allocateClassRepository;
        this.markRepository = markRepository;
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
    public OrderVo generateordervo(int classid, int userid) {
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
        order.setBegindate(helper.timeToDateString(classEntity.getBegindate()));
        return order;
    }

    @Override
    public String createunchooseorder(int classid, int userid, int people, int coupon) {

        ClassEntity classEntity= classRepository.getOne(classid);
        MemberEntity memberEntity=memberRepository.getOne(userid);
        UserInfoEntity userInfoEntity=userInfoRepository.getOne(userid);

        Helper helper=new Helper();
        int discount=helper.getDiscount(memberEntity.getAccumulate());
        double price=classEntity.getPrice();
        double totalprice=(price*people)*discount/100-coupon;

        String id=helper.generateOrderid();


        OrderEntity order =new OrderEntity();
        order.setId(id);
        order.setUserid(userid);
        order.setSchoolid(classEntity.getSchoolid());
        order.setClassid(classid);
        order.setTeacherid(classEntity.getTeacherid());
        order.setPrice(price);
        order.setPeoplenum(people);
        order.setTotalprice(totalprice);
        Timestamp nowtime=new Timestamp(System.currentTimeMillis());
        try {
            order.setTopaytime(helper.addfifteenmin(nowtime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setClassbegintime(classEntity.getBegindate());
        order.setBankaccount(userInfoEntity.getPhonenum());
        order.setUsecoupon(coupon);
        order.setChooseclass(0);
        order.setFirstclass(0);
        order.setSecondclass(0);
        order.setThirdclass(0);
        orderRepository.save(order);

        int oldcoupon=memberEntity.getCoupon();
        oldcoupon=oldcoupon-coupon;
        memberEntity.setCoupon(oldcoupon);
        memberRepository.save(memberEntity);

        return id;
    }

    @Override
    public String createchooseorder(int classid, int userid, int classnum, int people, int coupon) {

        ClassEntity classEntity= classRepository.getOne(classid);
        MemberEntity memberEntity=memberRepository.getOne(userid);
        UserInfoEntity userInfoEntity=userInfoRepository.getOne(userid);

        Helper helper=new Helper();
        int discount=helper.getDiscount(memberEntity.getAccumulate());
        double price=classEntity.getPrice();
        double totalprice=(price*people)*discount/100-coupon;


        String id=helper.generateOrderid();


        OrderEntity order =new OrderEntity();
        order.setId(id);
        order.setUserid(userid);
        order.setSchoolid(classEntity.getSchoolid());
        order.setClassid(classid);
        order.setTeacherid(classEntity.getTeacherid());
        order.setPrice(price);
        order.setPeoplenum(people);
        order.setTotalprice(totalprice);
        Timestamp nowtime=new Timestamp(System.currentTimeMillis());
        try {
            order.setTopaytime(helper.addfifteenmin(nowtime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setClassbegintime(classEntity.getBegindate());
        order.setBankaccount(userInfoEntity.getPhonenum());
        order.setUsecoupon(coupon);
        order.setChooseclass(1);
        order.setFirstclass(0);
        order.setSecondclass(0);
        order.setThirdclass(0);
        if(classnum==1){
            order.setFirstclass(1);
        }
        if(classnum==2){
            order.setSecondclass(1);
        }
        if(classnum==3){
            order.setThirdclass(1);
        }

        orderRepository.save(order);

        int oldcoupon=memberEntity.getCoupon();
        oldcoupon=oldcoupon-coupon;
        memberEntity.setCoupon(oldcoupon);
        memberRepository.save(memberEntity);

        return id;
    }

    @Override
    public OrderEntity getorderByid(String id) {
        return orderRepository.getOne(id);
    }

    @Override
    public boolean pay(String banksccount, String password, double price,String orderid) {

        if(bankRepository.getOne(banksccount).getPassword().equals(password)){
            BankEntity bankEntity=bankRepository.getOne(banksccount);
            double balance=bankEntity.getBalance()-price;
            bankEntity.setBalance(balance);
            OrderEntity orderEntity=orderRepository.getOne(orderid);

            orderEntity.setOrderstate(OrderState.PAYED);
            orderRepository.save(orderEntity);
            bankRepository.save(bankEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<ClassEntity> searchclass(String label) {

        List<ClassAndLabelEntity> classAndLabelEntities=classAndLabelRepository.findAllByLabel(label);
        List<ClassEntity> classEntityList=classRepository.findAll();
        List<ClassEntity> classlist=new ArrayList<>();
        for(ClassEntity c: classEntityList) {
            String classname = c.getName();
            if (classname.contains(label)) {
                classlist.add(c);
            }
        }
        return classlist;
    }

    @Override
    public void cancelmember(int userid) {
        UserInfoEntity userInfoEntity=userInfoRepository.getOne(userid);
        userInfoEntity.setMemberState(MemberState.INVALID);
        userInfoRepository.save(userInfoEntity);

    }

    @Override
    public void exchangecoupon(int userid, int point) {
        MemberEntity memberEntity=memberRepository.getOne(userid);
        memberEntity.setPoint(memberEntity.getPoint()-point);
        memberEntity.setCoupon(memberEntity.getCoupon()+point/100);
        memberRepository.save(memberEntity);
    }

    @Override
    public void modifyinfo(int userid, String name, String password, String phone) {

        UserInfoEntity userInfoEntity=userInfoRepository.getOne(userid);
        UserEntity userEntity=userRepository.getOne(userid);
        userInfoEntity.setName(name);
        userEntity.setPassword(MD5Util.encode(password));
        userInfoEntity.setPhonenum(phone);
        userInfoRepository.save(userInfoEntity);
        userRepository.save(userEntity);

    }

    @Override
    public List<OrderEntity> getunpayorder(int userid) {

        return orderRepository.findByUseridAndOrderstate(userid,OrderState.TOPAY);

    }

    @Override
    public List<OrderEntity> getcancelorder(int userid) {
        return orderRepository.findByUseridAndOrderstate(userid,OrderState.CANCEL);
    }

    @Override
    public List<OrderEntity> getpayedorder(int userid) {
        return orderRepository.findByUseridAndOrderstate(userid,OrderState.PAYED);
    }

    @Override
    public List<OrderEntity> getsuccessorder(int userid) {
        return orderRepository.findByUseridAndOrderstate(userid,OrderState.SUCCESS);
    }

    @Override
    public List<OrderEntity> getdrawbackorder(int userid) {
        return orderRepository.findByUseridAndOrderstate(userid,OrderState.DRAWBACK);
    }

    @Override
    public void drawbackorder(String orderid) throws ParseException{
        Helper helper=new Helper();
        OrderEntity order=orderRepository.getOne(orderid);
        double totalprice=order.getTotalprice();
        double backmoney = 0;
        int userid=order.getUserid();
        String bankaccount=userInfoRepository.getOne(userid).getPhonenum();
        BankEntity bankEntity=bankRepository.getOne(bankaccount);
        Timestamp nowtime=new Timestamp(System.currentTimeMillis());
        Timestamp classbegintime=order.getClassbegintime();
        if(helper.compare_date(nowtime,helper.minusnday(classbegintime,2))<=0){//开课两周，自动配班之前
            backmoney=totalprice*0.8;
            order.setOrderstate(OrderState.DRAWBACK);
        }
        if(helper.compare_date(nowtime,helper.minusnday(classbegintime,2))>0&&helper.compare_date(nowtime,classbegintime)<0){//开课两周到开课之间
            backmoney=totalprice*0.5;
            order.setOrderstate(OrderState.DRAWBACK);
        }
        if(helper.compare_date(nowtime,classbegintime)>=0){
            backmoney=0;
            order.setOrderstate(OrderState.DRAWBACK);
        }
        orderRepository.save(order);
        double balance=bankEntity.getBalance()+backmoney;
        bankEntity.setBalance(balance);
        bankRepository.save(bankEntity);

    }

    @Override
    public List<AllocateClassEntity> getmyclass(int userid) {
        return allocateClassRepository.findByUserid(userid);
    }

    @Override
    public List<MarkEntity> getmymark(int userid) {
        return markRepository.findByUserid(userid);
    }


}
