package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.service.RegisterApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SchoolController {

    private final RegisterApprovalService registerApprovalService;

    public SchoolController(RegisterApprovalService registerApprovalService) {
        this.registerApprovalService = registerApprovalService;
    }

    @RequestMapping(value = "/school/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("mail") String mail,@RequestParam("address") String address) {


        registerApprovalService.register(name,password,address,mail);

        return "user/index";


    }
    @RequestMapping("/school/register")
    public String register(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "school/register";
    }


}
