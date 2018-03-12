package cn.edu.nju.trainingcollege.service.impl;

import cn.edu.nju.trainingcollege.dao.ManagerRepository;
import cn.edu.nju.trainingcollege.entity.ManagerEntity;
import cn.edu.nju.trainingcollege.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerLoginServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public boolean login(String name, String password) {

        if(managerRepository.existsById(name)&&managerRepository.getOne(name).getPassword().equals(password)){
            return true;
        }
        else
            return false;
    }
}
