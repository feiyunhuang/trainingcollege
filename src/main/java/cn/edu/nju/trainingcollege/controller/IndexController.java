package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.TeacherEntity;
import cn.edu.nju.trainingcollege.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    private final ManagerService managerService;

    public IndexController(ManagerService managerService) {
        this.managerService = managerService;
    }


    @RequestMapping({"/", "/index"})
    public String index(Model model) {

        List<ClassEntity> classes=managerService.getEightHotClass();
        List<TeacherEntity> teachers=managerService.getThreeHotTeacher();

        model.addAttribute("classes",classes);
        model.addAttribute("teachers",teachers);

        return "index";
    }
}
