package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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




            return "redirect:/manager/list";
        }
        return "manager/login";

    }


    @RequestMapping("/delete")
    public String delete(String id) {
        managerService.disapproval(id);
        return "redirect:/manager/list";
    }
    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "manager/login";
    }

    @RequestMapping({"/list"})
    public String list(Model model) {
        List<RegisterApprovalEntity> registerApprovals=managerService.getAllApprovals();
        model.addAttribute("registerApprovals",registerApprovals);



        return "manager/approval";
    }
}
