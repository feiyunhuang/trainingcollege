package cn.edu.nju.trainingcollege.service;

import cn.edu.nju.trainingcollege.entity.*;

import java.util.List;

public interface ManagerService {
    boolean login(String name,String password);

    void disapproval(String id);

    void approval(String id);

    List<RegisterApprovalEntity> getAllApprovals();

    List<SchoolEntity> getAllSchools();

    List<ClassEntity> getEightHotClass();

    List<TeacherEntity> getThreeHotTeacher();
}
