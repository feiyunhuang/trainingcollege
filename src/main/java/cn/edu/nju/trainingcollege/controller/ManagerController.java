package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.service.ManagerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/manager")
@Controller
public class ManagerController {
    private final ManagerLoginService managerLoginService;


    @Autowired
    public ManagerController(ManagerLoginService managerLoginService) {
        this.managerLoginService = managerLoginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, @RequestParam("name") String name, @RequestParam("password") String password) {

        if(managerLoginService.login(name,password)==true){

//            UserEntity userEntity = userRepository.findByMail(mail);
//            UserInfoEntity userInfoEntity=userInfoRepository.getOne(userEntity.getId());
//            session.setAttribute("userid", userEntity.getId());
//
//            Helper helper=new Helper();
//            PersonInfoVo personInfoVo=new PersonInfoVo(userInfoEntity.getId(), mail, userInfoEntity.getName(), userInfoEntity.getMemberState().toString(), helper.timeToDateString(userInfoEntity.getRegistdate()),"../../static/portrait/timg.jpg",userInfoEntity.getSex(),userInfoEntity.getPhonenum());
//
//            model.addAttribute("personinfo",personInfoVo);


            return "manager/approval";
        }
        return "manager/login";

    }

    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "manager/login";
    }
}
