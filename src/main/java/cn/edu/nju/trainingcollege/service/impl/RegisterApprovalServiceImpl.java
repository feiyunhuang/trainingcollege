package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.dao.SchoolRepository;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.RegisterApprovalService;
import cn.edu.nju.trainingcollege.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterApprovalServiceImpl implements RegisterApprovalService {

    private final RegisterApprovalRepository registerApprovalRepository;
    private final SchoolRepository schoolRepository;
    private final MailService mailService;


    @Autowired
    public RegisterApprovalServiceImpl(RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository, MailService mailService) {
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
        this.mailService = mailService;
    }

    @Override
    public void register(String name, String password, String address, String mail) {
        mailService.send(mail,"trainingcollege","您好,"+name+"您的机构正在审批，审批通过会通过邮件发送给您！");
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
}
