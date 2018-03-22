package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.*;
import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.SchoolService;
import cn.edu.nju.trainingcollege.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;


@Service
public class SchoolServiceImpl implements SchoolService {

    private final RegisterApprovalRepository registerApprovalRepository;
    private final SchoolRepository schoolRepository;
    private final MailService mailService;
    private final ClassRepository classRepository;
    private final TeacherRepository teacherRepository;
    private final ChangeApprovalRepository changeApprovalRepository;
    private final OrderRepository orderRepository;
    private final MarkRepository markRepository;


    @Autowired
    public SchoolServiceImpl(RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository, MailService mailService, ClassRepository classRepository, TeacherRepository teacherRepository, ChangeApprovalRepository changeApprovalRepository, OrderRepository orderRepository, MarkRepository markRepository) {
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
        this.changeApprovalRepository = changeApprovalRepository;
        this.orderRepository = orderRepository;
        this.markRepository = markRepository;
    }

    @Override
    public void register(String name, String password, String address, String mail) {
        mailService.send(mail,"trainingcollege","您好,"+name+"您的机构正在由经理审批，请耐心等待，审批通过会通过邮件发送给您！");
        Helper helper = new Helper();
        String id;
        do {
            id = helper.generateSchoolid();

        } while (schoolRepository.getOne(id) == null && registerApprovalRepository.getOne(id) == null);
        RegisterApprovalEntity registerApprovalEntity=new RegisterApprovalEntity();
       registerApprovalEntity.setId(id);
       registerApprovalEntity.setName(name);
       registerApprovalEntity.setPassword(password);
       registerApprovalEntity.setMail(mail);
       registerApprovalEntity.setAddress(address);
        registerApprovalRepository.save(registerApprovalEntity);

    }

    @Override
    public boolean login(String name, String password) {
        if(schoolRepository.existsById(name)&&schoolRepository.getOne(name).getPassword().equals(password)){
            return true;
        }
        else
            return false;
    }

    @Override
    public List<ClassEntity> findMyClass(String schoolid) {

        return classRepository.findBySchoolid(schoolid);
    }

    @Override
    public List<TeacherEntity> findAllTeacher(String schoolid) {

        return teacherRepository.findBySchoolid(schoolid);

    }

    @Override
    public void addclass(String classname, String schoolid, String timeaweek, int week, int classnum, int studentaclass, double price, int teacherid, String daytime, String begindate, String description) {

        Helper helper=new Helper();
        try {
            begindate=helper.strtostr(begindate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ClassEntity classEntity=new ClassEntity();
        classEntity.setName(classname);
        classEntity.setSchoolid(schoolid);
        classEntity.setTimeaweek(timeaweek);
        classEntity.setWeek(week);
        classEntity.setClassnum(classnum);
        classEntity.setStudentaclass(studentaclass);
        classEntity.setPrice(price);
        classEntity.setTeacherid(teacherid);
        classEntity.setDaytime(daytime);
        classEntity.setBegindate(helper.getTimeStamp(begindate));
        classEntity.setDescription(description);

        classRepository.save(classEntity);
    }

    @Override
    public SchoolEntity getschoolinfo(String schoolid) {
        return schoolRepository.getOne(schoolid);
    }

    @Override
    public void modifyschoolinfo(String schoolid, String schoolname, String password, String mail, String address) {

        ChangeApprovalEntity changeApprovalEntity=new ChangeApprovalEntity();
        changeApprovalEntity.setId(schoolid);
        changeApprovalEntity.setName(schoolname);
        changeApprovalEntity.setPassword(password);
        changeApprovalEntity.setMail(mail);
        changeApprovalEntity.setAddress(address);
        changeApprovalRepository.save(changeApprovalEntity);

    }

    @Override
    public void addteacher(String name, String description,String schoolid) {

        TeacherEntity teacherEntity=new TeacherEntity();
        teacherEntity.setName(name);
        teacherEntity.setSchoolid(schoolid);
        teacherEntity.setDescription(description);
        teacherRepository.save(teacherEntity);
    }

    @Override
    public void deleteteacher(int teacherid) {
        TeacherEntity teacherEntity=teacherRepository.getOne(teacherid);
        teacherRepository.delete(teacherEntity);
    }

    @Override
    public List<OrderEntity> getclassorder(int classid) {
        return orderRepository.findByClassid(classid);
    }

    @Override
    public void addmark(int userid, int classid, String classname, int score) {

        MarkEntity markEntity=new MarkEntity();
        markEntity.setUserid(userid);
        markEntity.setClassid(classid);
        markEntity.setClassname(classname);
        markEntity.setScore(score);
        markRepository.save(markEntity);
    }
}
