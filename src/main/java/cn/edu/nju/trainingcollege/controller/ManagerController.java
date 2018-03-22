package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.entity.*;
import cn.edu.nju.trainingcollege.service.ManagerService;
import cn.edu.nju.trainingcollege.vo.DataVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.PriceVo;
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

    @RequestMapping({"/alluser"})
    public String allusers(Model model){
        List<MemberInfoVo> memberInfoVoList =managerService.getalluser();
        model.addAttribute("users",memberInfoVoList);
        return "manager/alluser";
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

    @RequestMapping({"/pricedata"})
    public String showpricedata(Model model){

        return "manager/pricedata";
    }


    @RequestMapping("/watchschool")
    public String watchschool(String schoolid,Model model) {
        List<ClassEntity> classEntityList=managerService.findclassbyschoolid(schoolid);
        model.addAttribute("classes",classEntityList);
        return "manager/watchschool";
    }

    @RequestMapping("/watchuser")
    public String watchuser(int userid,Model model) {
        List<OrderEntity> orderEntityList=managerService.findorderbyuserid(userid);
        model.addAttribute("orders",orderEntityList);
        return "manager/watchuser";
    }




    @GetMapping("/data")
    @ResponseBody
    public DataVo data() {
        return managerService.getdata();

    }


    @GetMapping("/getdata")
    @ResponseBody
    public List<PriceVo> pricedata() {
        return managerService.getpricedata();

    }

}
