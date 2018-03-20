package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.entity.ChangeApprovalEntity;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.entity.SchoolEntity;
import cn.edu.nju.trainingcollege.service.ManagerService;
import cn.edu.nju.trainingcollege.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/manager")
@Controller
public class ManagerController {
    private final ManagerService managerService;


    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, @RequestParam("name") String name, @RequestParam("password") String password) {

        if(managerService.login(name,password)==true){

            return "redirect:/manager/approval";
        }
        return "manager/login";

    }


    @RequestMapping("/delete")
    public String delete(String id) {
        managerService.disapproval(id);
        return "redirect:/manager/approval";
    }

    @RequestMapping("/add")
    public String add(String id) {
        managerService.approval(id);
        return "redirect:/manager/allschools";
    }


    @RequestMapping("/yeschange")
    public String yeschange(String id) {
        managerService.yeschange(id);
        return "redirect:/manager/changeapproval";
    }

    @RequestMapping("/nochange")
    public String nochange(String id) {
        managerService.nochange(id);
        return "redirect:/manager/changeapproval";
    }


    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "manager/login";
    }

    @RequestMapping({"/approval"})
    public String approval(Model model) {
        List<RegisterApprovalEntity> registerApprovals=managerService.getAllApprovals();
        model.addAttribute("registerApprovals",registerApprovals);
        return "manager/approval";
    }

    @RequestMapping({"/allschools"})
    public String allschool(Model model){
        List<SchoolEntity> schools =managerService.getAllSchools();
        model.addAttribute("schools",schools);
        return "manager/allschools";
    }


    @RequestMapping({"/changeapproval"})
    public String showchangeapproval(Model model){
        List<ChangeApprovalEntity> changeApprovalEntities=managerService.getchangeschoolinfo();
        model.addAttribute("changeapprovals",changeApprovalEntities);
        return "manager/changeapproval";
    }

    @RequestMapping({"/statistics"})
    public String showstatistics(Model model){

        return "manager/statistics";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<DataVo> data() {

        List<DataVo> list=new ArrayList<>();
        DataVo vo1=new DataVo(400,"我的电脑");
        DataVo vo2=new DataVo(335,"直接访问");
        DataVo vo3=new DataVo(310,"邮件营销");
        DataVo vo4=new DataVo(274,"联盟广告");
        DataVo vo5=new DataVo(235,"视频广告");

        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        list.add(vo5);
        return list;
    }


}
