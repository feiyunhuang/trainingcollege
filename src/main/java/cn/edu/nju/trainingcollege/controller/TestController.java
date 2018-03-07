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
@RequestMapping("/student")
public class TestController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(value = "/allstudent")
    public List<UserInfoEntity> getAllStudentInfo() {

//        Iterable iterable = studentRepository.findAll();
//        Iterator iterator = iterable.iterator();
//        List<Student> students = new ArrayList<Student>();
//        while(iterator.hasNext()){
//            students.add((Student) iterator.next());
//        }
//
//        return students;
        return userInfoRepository.findAll();

    }
}
