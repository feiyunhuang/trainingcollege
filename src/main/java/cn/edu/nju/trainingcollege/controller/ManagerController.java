package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.dao.RegisterApprovalRepository;
import cn.edu.nju.trainingcollege.entity.RegisterApprovalEntity;
import cn.edu.nju.trainingcollege.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/manager")
@Controller
public class ManagerController {
    private final ManagerLoginService managerLoginService;
    private final RegisterApprovalRepository registerApprovalRepository;

    @Autowired
    public ManagerController(ManagerLoginService managerLoginService, RegisterApprovalRepository registerApprovalRepository) {
        this.managerLoginService = managerLoginService;
        this.registerApprovalRepository = registerApprovalRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, @RequestParam("name") String name, @RequestParam("password") String password) {

        if(managerLoginService.login(name,password)==true){




            return "redirect:/manager/list";
        }
        return "manager/login";

    }


    @RequestMapping("/delete")
    public String delete(String id) {
        RegisterApprovalEntity registerApprovalEntity=registerApprovalRepository.getOne(id);
        registerApprovalRepository.delete(registerApprovalEntity);
        return "redirect:/manager/list";
    }
    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "manager/login";
    }

    @RequestMapping({"/list"})
    public String list(Model model) {
        List<RegisterApprovalEntity> registerApprovals=registerApprovalRepository.findAll();
        model.addAttribute("registerApprovals",registerApprovals);



        return "manager/approval";
    }
}
