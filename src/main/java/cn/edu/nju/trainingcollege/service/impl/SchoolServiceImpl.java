package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.ClassRepository;
import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.dao.SchoolRepository;
import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.SchoolService;
import cn.edu.nju.trainingcollege.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SchoolServiceImpl implements SchoolService {

    private final RegisterApprovalRepository registerApprovalRepository;
    private final SchoolRepository schoolRepository;
    private final MailService mailService;
    private final ClassRepository classRepository;


    @Autowired
    public SchoolServiceImpl(RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository, MailService mailService, ClassRepository classRepository) {
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
        this.mailService = mailService;
        this.classRepository = classRepository;
    }

    @Override
    public void register(String name, String password, String address, String mail) {
        mailService.send(mail,"trainingcollege","您好,"+name+"您的机构正在由经理审批，请耐心等待，审批通过会通过邮件发送给您！");
        Helper helper = new Helper();
        String id;
        do {
            id = helper.GenerateId();

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
}
