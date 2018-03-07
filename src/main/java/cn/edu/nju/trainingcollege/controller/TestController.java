package cn.edu.nju.trainingcollege.controller;

import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.dao.UserRepository;

import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(value = "/test")
    public List<UserInfoEntity> getAll() {


        return userInfoRepository.findAll();

    }
}
