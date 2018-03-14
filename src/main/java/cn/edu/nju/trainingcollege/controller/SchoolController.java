package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping(value = "/school")
@Controller
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, @RequestParam("schoolid") String schoolid, @RequestParam("password") String password) {

        if(schoolService.login(schoolid,password)==true){


            session.setAttribute("schoolid",schoolid);

            return "redirect:/school/loginsuccess";
        }
        return "school/login";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("mail") String mail,@RequestParam("address") String address) {


        schoolService.register(name,password,address,mail);
        return "school/registersuccess";

    }

    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "school/login";
    }

    @RequestMapping({"/loginsuccess"})
    public String approval(Model model,HttpSession session) {
        String schoolid= (String) session.getAttribute("schoolid");

        List<ClassEntity> classes=schoolService.findMyClass(schoolid);
        model.addAttribute("classes",classes);

        return "school/schoolinfo";
    }


    @RequestMapping({"/addclass"})
    public String addclass(){
        return "school/addclass";
    }


    @RequestMapping("/register")
    public String register(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "school/register";
    }


}
