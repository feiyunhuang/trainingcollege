package cn.edu.nju.trainingcollege.controller;

import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
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

@RequestMapping(value = "/user")
@Controller
public class UserController {

    private final UserRegisterService userRegisterService;
    private final UserLoginService userLoginService;
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    @Autowired
    public UserController(UserRegisterService userRegisterService, UserLoginService userLoginService, UserRepository userRepository, UserInfoRepository userInfoRepository) {
        this.userRegisterService = userRegisterService;
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
            PersonInfoVo personInfoVo=new PersonInfoVo(userInfoEntity.getId(), mail, userInfoEntity.getName(), userInfoEntity.getMemberState().toString(), helper.timeToDateString(userInfoEntity.getRegistdate()),"../../static/portrait/timg.jpg",userInfoEntity.getSex(),userInfoEntity.getPhonenum());

            model.addAttribute("personinfo",personInfoVo);


            return "user/userinfo";
        }
        return "/index";

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("mail") String mail,@RequestParam("password") String password,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("sex") String sex) {

        userRegisterService.register(mail,password,name,phone,sex);


           return "/index";


    }




    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "/index";
    }

    @RequestMapping("/register")
    public String register(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "user/register";
    }
}

