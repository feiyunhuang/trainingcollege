package cn.edu.nju.trainingcollege.controller;

import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.UserLoginService;
import cn.edu.nju.trainingcollege.service.UserRegisterService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.vo.PersonInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    private final UserRegisterService userRegisterService;
    private final MailService mailService;
    private final UserLoginService userLoginService;
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserController(UserRegisterService userRegisterService, MailService mailService, UserLoginService userLoginService, UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.userRegisterService = userRegisterService;
        this.mailService = mailService;
        this.userLoginService = userLoginService;
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,HttpSession session, @RequestParam("username") String mail, @RequestParam("password") String password) {

        if(userLoginService.login(mail,password)==true){

           UserEntity userEntity = userRepository.findByMail(mail);
            UserInfoEntity userInfoEntity=userInfoRepository.getOne(userEntity.getId());
            session.setAttribute("userid", userEntity.getId());

            Helper helper=new Helper();
            PersonInfoVo personInfoVo=new PersonInfoVo(userInfoEntity.getId(), mail, userInfoEntity.getName(), userInfoEntity.getMemberState().toString(), userInfoEntity.getBalance(), helper.timeToDateString(userInfoEntity.getRegistdate()),"../../static/portrait/timg.jpg");

            model.addAttribute("personinfo",personInfoVo);


            return "user/userinfo";
        }
        return "user/index";

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("mail") String mail,@RequestParam("password") String password,@RequestParam("name") String name) {

        userRegisterService.register(mail,password,name);
            mailService.send(mail,"trainingcollege","注册成功,"+"您的密码是"+password+",请牢记");

           return "redirect:/index";


    }




    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "user/index";
    }

    @RequestMapping("/register")
    public String register(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "user/register";
    }
}

