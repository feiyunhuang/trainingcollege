package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.ManagerRepository;
import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.entity.ManagerEntity;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final RegisterApprovalRepository registerApprovalRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, RegisterApprovalRepository registerApprovalRepository) {
        this.managerRepository = managerRepository;
        this.registerApprovalRepository = registerApprovalRepository;
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
    public List<RegisterApprovalEntity> getAllApprovals() {
        return registerApprovalRepository.findAll();
    }

}
