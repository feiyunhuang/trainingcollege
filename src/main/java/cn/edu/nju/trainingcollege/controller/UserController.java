package cn.edu.nju.trainingcollege.controller;

import cn.edu.nju.trainingcollege.dao.UserRepository;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public UserController(UserRepository userRepository, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.javaMailSender = javaMailSender;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("mail") String mail,@RequestParam("password") String password) {

        UserEntity entity = new UserEntity();
        entity.setMail(mail);
        entity.setPassword(password);





            entity = userRepository.save(entity);


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("liuhehuangyunfei@163.com");
        message.setTo("1140617436@qq.com");
        message.setSubject("标题：测试标题");
        message.setText("测试内容部份");
        javaMailSender.send(message);

           return "redirect:/index";


    }

    @PostMapping("/addStudent")
    public UserEntity addUser(@RequestParam("mail") String mail, @RequestParam("password") String password){
        UserEntity student=new UserEntity();
        student.setMail(mail);
        student.setPassword(password);
        return userRepository.save(student);
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

