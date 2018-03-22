package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.*;
import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.entity.constant.OrderState;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.ManagerService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.vo.DataVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.PriceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final RegisterApprovalRepository registerApprovalRepository;
    private final SchoolRepository schoolRepository;
    private final MailService mailService;
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;
    private final ChangeApprovalRepository changeApprovalRepository;
    private final UserInfoRepository userInfoRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository, MailService mailService, ClassRepository classRepository, TeacherRepository teacherRepository, ChangeApprovalRepository changeApprovalRepository, UserInfoRepository userInfoRepository, MemberRepository memberRepository, OrderRepository orderRepository) {
        this.managerRepository = managerRepository;
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
        this.changeApprovalRepository = changeApprovalRepository;
        this.userInfoRepository = userInfoRepository;
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean login(String name, String password) {

        if(managerRepository.existsById(name)&&managerRepository.getOne(name).getPassword().equals(password)){
            return true;
        }
        else
            return false;
    }

    @Override
    public void disapproval(String id) {

        RegisterApprovalEntity registerApprovalEntity=registerApprovalRepository.getOne(id);
        registerApprovalRepository.delete(registerApprovalEntity);
    }

    @Override
    public void approval(String id) {
        RegisterApprovalEntity registerApprovalEntity=registerApprovalRepository.getOne(id);
        SchoolEntity schoolEntity= new SchoolEntity();
        schoolEntity.setId(registerApprovalEntity.getId());
        schoolEntity.setName(registerApprovalEntity.getName());
        schoolEntity.setPassword(registerApprovalEntity.getPassword());
        schoolEntity.setMail(registerApprovalEntity.getMail());
        schoolEntity.setAddress(registerApprovalEntity.getAddress());
        mailService.send(registerApprovalEntity.getMail(),"trainingcollege","您好,您的机构"+registerApprovalEntity.getName()+"已通过审批，您可以通过7位识别码"+registerApprovalEntity.getId()+"登录");
        schoolRepository.save(schoolEntity);
        registerApprovalRepository.delete(registerApprovalEntity);

    }

    @Override
    public List<RegisterApprovalEntity> getAllApprovals() {
        return registerApprovalRepository.findAll();
    }

    @Override
    public List<SchoolEntity> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public List<ClassEntity> getEightHotClass() {

        List<ClassEntity> classes=classRepository.findAll();
        List<ClassEntity> res=new ArrayList<>();
        for(int i=0;i<8;i++){
            res.add(classes.get(i));
        }
        return res;

    }

    @Override
    public List<TeacherEntity> getThreeHotTeacher() {
        List<TeacherEntity> teachers=teacherRepository.findAll();
        List<TeacherEntity> res=new ArrayList<>();
        for(int i=0;i<3;i++){
            res.add(teachers.get(i));
        }
        return res;
    }

    @Override
    public List<ChangeApprovalEntity> getchangeschoolinfo() {
        return changeApprovalRepository.findAll();
    }

    @Override
    public void yeschange(String id) {

        SchoolEntity schoolEntity=schoolRepository.getOne(id);
        ChangeApprovalEntity changeApprovalEntity=changeApprovalRepository.getOne(id);

        schoolEntity.setName(changeApprovalEntity.getName());
        schoolEntity.setPassword(changeApprovalEntity.getPassword());
        schoolEntity.setMail(changeApprovalEntity.getMail());
        schoolEntity.setAddress(changeApprovalEntity.getAddress());
        schoolRepository.save(schoolEntity);
        changeApprovalRepository.delete(changeApprovalEntity);
    }

    @Override
    public void nochange(String id) {
        ChangeApprovalEntity changeApprovalEntity=changeApprovalRepository.getOne(id);
        changeApprovalRepository.delete(changeApprovalEntity);

    }

    @Override
    public List<MemberInfoVo> getalluser() {
        Helper helper=new Helper();
        List<MemberInfoVo> memberInfoVoList=new ArrayList<>();
        List<MemberEntity> memberEntityList=memberRepository.findAll();
        for(MemberEntity memberEntity : memberEntityList){
            int id=memberEntity.getId();
            UserInfoEntity userInfoEntity=userInfoRepository.getOne(id);
            MemberInfoVo memberInfoVo=new MemberInfoVo();
            memberInfoVo.setId(id);
            memberInfoVo.setPoint(memberEntity.getPoint());
            memberInfoVo.setLevel(memberEntity.getLevel());
            memberInfoVo.setRegistdate(helper.timeToDateString(userInfoEntity.getRegistdate()));
            memberInfoVo.setDiscount(""+helper.getDiscount(memberEntity.getAccumulate()));
            memberInfoVo.setName(userInfoEntity.getName());
            memberInfoVo.setCoupon(memberEntity.getCoupon());
            memberInfoVoList.add(memberInfoVo);
        }
        return memberInfoVoList;
    }

    @Override
    public List<ClassEntity> findclassbyschoolid(String schoolid) {
        return classRepository.findBySchoolid(schoolid);
    }

    @Override
    public List<OrderEntity> findorderbyuserid(int userid) {
        return orderRepository.findByUserid(userid);
    }

    @Override
    public DataVo getdata() {

        DataVo data=new DataVo();
        Helper helper=new Helper();

        List<String> orderstate=new ArrayList<>();
        orderstate.add("CANCEL");
        orderstate.add("PAYED");
        orderstate.add("SUCCESS");
        orderstate.add("DRAWBACK");
        data.setOrderstate(orderstate);

        List<String> weekday=new ArrayList<>();
        weekday.add("周一");
        weekday.add("周二");
        weekday.add("周三");
        weekday.add("周四");
        weekday.add("周五");
        weekday.add("周六");
        weekday.add("周日");
        data.setWeekday(weekday);

        List<Integer> cancelnum=new ArrayList<>(7);
        List<Integer> payednum=new ArrayList<>(7);
        List<Integer> successnum=new ArrayList<>(7);
        List<Integer> drawbacknum=new ArrayList<>(7);
        for(int i=0;i<7;i++){
            cancelnum.add(0);
        }
        for(int i=0;i<7;i++){
            payednum.add(0);
        }
        for(int i=0;i<7;i++){
            successnum.add(0);
        }
        for(int i=0;i<7;i++){
            drawbacknum.add(0);
        }

        List<OrderEntity> cancelorder=orderRepository.findByOrderstate(OrderState.CANCEL);
        List<OrderEntity> payedorder=orderRepository.findByOrderstate(OrderState.PAYED);
        List<OrderEntity> successorder=orderRepository.findByOrderstate(OrderState.SUCCESS);
        List<OrderEntity> drawbackorder=orderRepository.findByOrderstate(OrderState.DRAWBACK);

        for(int i=0;i<cancelorder.size();i++){
            String str=helper.getWeekOfDate(cancelorder.get(i).getCreatetime());
            int j=0;
            switch (str){
                case "周一":
                    j=cancelnum.get(0);
                    j++;
                    cancelnum.set(0,j);
                    break;
                case "周二":
                    j=cancelnum.get(1);
                    j++;
                    cancelnum.set(1,j);
                    break;
                case "周三":
                    j=cancelnum.get(2);
                    j++;
                    cancelnum.set(2,j);
                    break;
                case "周四":
                    j=cancelnum.get(3);
                    j++;
                    cancelnum.set(3,j);
                    break;
                case "周五":
                    j=cancelnum.get(4);
                    j++;
                    cancelnum.set(4,j);
                    break;
                case "周六":
                    j=cancelnum.get(5);
                    j++;
                    cancelnum.set(5,j);
                    break;
                case "周日":
                    j=cancelnum.get(6);
                    j++;
                    cancelnum.set(6,j);
                    break;
            }

        }
        data.setCancelnum(cancelnum);


        for(int i=0;i<payedorder.size();i++){
            String str=helper.getWeekOfDate(payedorder.get(i).getCreatetime());
            int j=0;
            switch (str){
                case "周一":
                    j=payednum.get(0);
                    j++;
                    payednum.set(0,j);
                    break;
                case "周二":
                    j=payednum.get(1);
                    j++;
                    payednum.set(1,j);
                    break;
                case "周三":
                    j=payednum.get(2);
                    j++;
                    payednum.set(2,j);
                    break;
                case "周四":
                    j=payednum.get(3);
                    j++;
                    payednum.set(3,j);
                    break;
                case "周五":
                    j=payednum.get(4);
                    j++;
                    payednum.set(4,j);
                    break;
                case "周六":
                    j=payednum.get(5);
                    j++;
                    payednum.set(5,j);
                    break;
                case "周日":
                    j=payednum.get(6);
                    j++;
                    payednum.set(6,j);
                    break;
            }

        }
        data.setPayednum(payednum);

        for(int i=0;i<successorder.size();i++){
            String str=helper.getWeekOfDate(successorder.get(i).getCreatetime());
            int j=0;
            switch (str){
                case "周一":
                    j=successnum.get(0);
                    j++;
                    successnum.set(0,j);
                    break;
                case "周二":
                    j=successnum.get(1);
                    j++;
                    successnum.set(1,j);
                    break;
                case "周三":
                    j=successnum.get(2);
                    j++;
                    successnum.set(2,j);
                    break;
                case "周四":
                    j=successnum.get(3);
                    j++;
                    successnum.set(3,j);
                    break;
                case "周五":
                    j=successnum.get(4);
                    j++;
                    successnum.set(4,j);
                    break;
                case "周六":
                    j=successnum.get(5);
                    j++;
                    successnum.set(5,j);
                    break;
                case "周日":
                    j=successnum.get(6);
                    j++;
                    successnum.set(6,j);
                    break;
            }

        }
        data.setSuccessnum(successnum);


        for(int i=0;i<drawbackorder.size();i++){
            String str=helper.getWeekOfDate(drawbackorder.get(i).getCreatetime());
            int j=0;
            switch (str){
                case "周一":
                    j=drawbacknum.get(0);
                    j++;
                    drawbacknum.set(0,j);
                    break;
                case "周二":
                    j=drawbacknum.get(1);
                    j++;
                    drawbacknum.set(1,j);
                    break;
                case "周三":
                    j=drawbacknum.get(2);
                    j++;
                    drawbacknum.set(2,j);
                    break;
                case "周四":
                    j=drawbacknum.get(3);
                    j++;
                    drawbacknum.set(3,j);
                    break;
                case "周五":
                    j=drawbacknum.get(4);
                    j++;
                    drawbacknum.set(4,j);
                    break;
                case "周六":
                    j=drawbacknum.get(5);
                    j++;
                    drawbacknum.set(5,j);
                    break;
                case "周日":
                    j=drawbacknum.get(6);
                    j++;
                    drawbacknum.set(6,j);
                    break;
            }

        }
        data.setDrawbacknum(drawbacknum);


        return data;
    }

    @Override
    public List<PriceVo> getpricedata() {
        List<OrderEntity> topayorder=orderRepository.findByOrderstate(OrderState.TOPAY);
        List<OrderEntity> cancelorder=orderRepository.findByOrderstate(OrderState.CANCEL);
        List<OrderEntity> payedorder=orderRepository.findByOrderstate(OrderState.PAYED);
        List<OrderEntity> successorder=orderRepository.findByOrderstate(OrderState.SUCCESS);
        List<OrderEntity> drawbackorder=orderRepository.findByOrderstate(OrderState.DRAWBACK);

        double topaysum=0;
        for(OrderEntity n : topayorder){
            topaysum=topaysum+n.getTotalprice();
        }
        PriceVo topay=new PriceVo();
        topay.setValue(topaysum);
        topay.setName("待支付订单总额");


        double cancelsum=0;
        for(OrderEntity n : cancelorder){
            cancelsum=cancelsum+n.getTotalprice();
        }
        PriceVo cancel=new PriceVo();
        cancel.setValue(cancelsum);
        cancel.setName("取消订单总额");

        double payedsum=0;
        for(OrderEntity n : payedorder){
            payedsum=payedsum+n.getTotalprice();
        }
        PriceVo payed=new PriceVo();
        payed.setValue(payedsum);
        payed.setName("已支付订单总额");

        double successsum=0;
        for(OrderEntity n : successorder){
            successsum=successsum+n.getTotalprice();
        }
        PriceVo success=new PriceVo();
        success.setValue(successsum);
        success.setName("已完成订单总额");

        double drawbacksum=0;
        for(OrderEntity n : drawbackorder){
            drawbacksum=drawbacksum+n.getTotalprice();
        }
        PriceVo drawback=new PriceVo();
        drawback.setValue(drawbacksum);
        drawback.setName("退订订单总额");

        List<PriceVo> list=new ArrayList<>();
        list.add(topay);
        list.add(cancel);
        list.add(payed);
        list.add(success);
        list.add(drawback);

        return list;

    }


}
