package cn.edu.nju.trainingcollege.controller;



import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserInfoController {

    private final UserInfoRepository userInfoRepository;

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @RequestMapping("/list")
    public String list(Model model) {
        List<UserInfoEntity> list =userInfoRepository.findAll();
        model.addAttribute("list", list);
        return "user/list";
    }
}