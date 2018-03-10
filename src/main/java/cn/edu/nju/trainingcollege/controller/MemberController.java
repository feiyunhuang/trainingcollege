package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.dao.MemberRepository;
import cn.edu.nju.trainingcollege.dao.UserInfoRepository;
import cn.edu.nju.trainingcollege.entity.MemberEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    private final UserInfoRepository userInfoRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(UserInfoRepository userInfoRepository, MemberRepository memberRepository) {
        this.userInfoRepository = userInfoRepository;
        this.memberRepository = memberRepository;
    }

    @RequestMapping({"/", "/memberinfo"})
    public String index(Model model,HttpSession session) {

        int id= (int) session.getAttribute("userid");
        UserInfoEntity userInfoEntity=userInfoRepository.getOne(id);
        MemberEntity memberEntity=memberRepository.getOne(id);
        Helper helper=new Helper();
        MemberInfoVo memberInfoVo=new MemberInfoVo(id,memberEntity.getPoint(),memberEntity.getLevel(),memberEntity.getAccumulate(),helper.timeToDateString(userInfoEntity.getRegistdate()),""+helper.getDiscount(memberEntity.getAccumulate()),userInfoEntity.getName());
        model.addAttribute("memberinfo",memberInfoVo);

        return "member/memberinfo";
    }
}
