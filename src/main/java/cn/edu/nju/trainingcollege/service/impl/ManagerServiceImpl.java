package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.*;
import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.entity.SchoolEntity;
import cn.edu.nju.trainingcollege.entity.TeacherEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.ManagerService;
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

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository, MailService mailService, ClassRepository classRepository, TeacherRepository teacherRepository) {
        this.managerRepository = managerRepository;
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
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


}
