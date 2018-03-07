package cn.edu.nju.trainingcollege.controller;

import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.service.MailService;
import cn.edu.nju.trainingcollege.service.StudentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class UserController {

    private final StudentRegisterService studentRegisterService;
    private final MailService mailService;

    @Autowired
    public UserController(StudentRegisterService studentRegisterService,MailService mailService) {
        this.studentRegisterService = studentRegisterService;
        this.mailService = mailService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("mail") String mail,@RequestParam("password") String password,@RequestParam("name") String name) {

        studentRegisterService.save(mail,password,name);
            mailService.send("1140617436@qq.com","标题：测试标题","测试内容部份");

           return "redirect:/index";


    }


}

