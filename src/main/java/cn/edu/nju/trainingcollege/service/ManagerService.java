package cn.edu.nju.trainingcollege.service;

import cn.edu.nju.trainingcollege.entity.ManagerEntity;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;

import java.util.List;

public interface ManagerService {
    boolean login(String name,String password);

    void disapproval(String id);

    void approval(String id);

    List<RegisterApprovalEntity> getAllApprovals();
}
