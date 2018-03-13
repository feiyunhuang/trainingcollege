package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.ManagerRepository;
import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.dao.SchoolRepository;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.entity.SchoolEntity;
import cn.edu.nju.trainingcollege.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final RegisterApprovalRepository registerApprovalRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, RegisterApprovalRepository registerApprovalRepository, SchoolRepository schoolRepository) {
        this.managerRepository = managerRepository;
        this.registerApprovalRepository = registerApprovalRepository;
        this.schoolRepository = schoolRepository;
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

}
