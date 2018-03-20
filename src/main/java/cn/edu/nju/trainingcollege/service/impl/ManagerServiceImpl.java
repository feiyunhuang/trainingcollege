package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.*;
import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.ManagerService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
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

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository, MailService mailService, ClassRepository classRepository, TeacherRepository teacherRepository, ChangeApprovalRepository changeApprovalRepository, UserInfoRepository userInfoRepository, MemberRepository memberRepository) {
        this.managerRepository = managerRepository;
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
        this.changeApprovalRepository = changeApprovalRepository;
        this.userInfoRepository = userInfoRepository;
        this.memberRepository = memberRepository;
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


}
