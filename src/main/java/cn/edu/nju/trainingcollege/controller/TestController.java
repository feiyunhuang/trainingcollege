package cn.edu.nju.trainingcollege.controller;

import cn.edu.nju.trainingcollege.dao.UserInfoRepository;

import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class TestController {

    @Autowired
    private UserInfoRepository userInfoRepository;

//    @GetMapping(value = "/allstudent")
//    public UserInfoEntity getAllStudentInfo() {
//
////        Iterable iterable = studentRepository.findAll();
////        Iterator iterator = iterable.iterator();
////        List<Student> students = new ArrayList<Student>();
////        while(iterator.hasNext()){
////            students.add((Student) iterator.next());
////        }
////
////        return students;
//        Integer id=1;
//        return userInfoRepository.findOne(id);
//
//    }

    @GetMapping(value = "/person/{id}")
    public UserInfoEntity personFindOne(@PathVariable("id") Integer id) {
        return userInfoRepository.getOne(id);
    }
}
