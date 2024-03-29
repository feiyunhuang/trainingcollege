package cn.edu.nju.trainingcollege.service;

import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.vo.DataVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.PriceVo;

import java.util.List;

public interface ManagerService {
    boolean login(String name,String password);

    void disapproval(String id);

    void approval(String id);

    List<RegisterApprovalEntity> getAllApprovals();

    List<SchoolEntity> getAllSchools();

    List<ClassEntity> getEightHotClass();

    List<TeacherEntity> getThreeHotTeacher();

    List<ChangeApprovalEntity> getchangeschoolinfo();

    void yeschange(String id);

    void nochange (String id);

    List<MemberInfoVo> getalluser();

    List<ClassEntity> findclassbyschoolid(String schoolid);

    List<OrderEntity> findorderbyuserid(int userid);

    DataVo getdata();

    List<PriceVo> getpricedata();
}
