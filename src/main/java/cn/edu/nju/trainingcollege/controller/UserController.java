package cn.edu.nju.trainingcollege.controller;


import cn.edu.nju.trainingcollege.entity.ClassEntity;
import cn.edu.nju.trainingcollege.entity.OrderEntity;
import cn.edu.nju.trainingcollege.entity.UserEntity;
import cn.edu.nju.trainingcollege.entity.UserInfoEntity;
import cn.edu.nju.trainingcollege.service.UserService;
import cn.edu.nju.trainingcollege.util.Helper;
import cn.edu.nju.trainingcollege.vo.ClassInfoVo;
import cn.edu.nju.trainingcollege.vo.MemberInfoVo;
import cn.edu.nju.trainingcollege.vo.OrderVo;
import cn.edu.nju.trainingcollege.vo.PersonInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model,HttpSession session, @RequestParam("username") String mail, @RequestParam("password") String password) {

        if(userService.login(mail,password)==true){


           UserEntity userEntity = userService.findByMail(mail);
            UserInfoEntity userInfoEntity=userService.getUserInfoById(userEntity.getId());
            session.setAttribute("bankaccount",userInfoEntity.getPhonenum());
            session.setAttribute("userid", userEntity.getId());
            session.setAttribute("mail",mail);


            return "redirect:/user/userinfo";
        }
        return "user/wrongpassword";

    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("mail") String mail,@RequestParam("password") String password,@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("sex") String sex) {

        userService.register(mail,password,name,phone,sex);


           return "/index";


    }


    @RequestMapping({"/userinfo"})
    public String userinfo(Model model,HttpSession session){

        String mail= (String) session.getAttribute("mail");
        UserEntity userEntity = userService.findByMail(mail);
        UserInfoEntity userInfoEntity=userService.getUserInfoById(userEntity.getId());

        Helper helper=new Helper();
        PersonInfoVo personInfoVo=new PersonInfoVo(userInfoEntity.getId(), mail, userInfoEntity.getName(), userInfoEntity.getMemberState().toString(), helper.timeToDateString(userInfoEntity.getRegistdate()),"../../static/portrait/timg.jpg",userInfoEntity.getSex(),userInfoEntity.getPhonenum());

        model.addAttribute("personinfo",personInfoVo);

        return "user/userinfo";
    }

    @RequestMapping({"/memberinfo"})
    public String index(Model model,HttpSession session) {

        int id= (int) session.getAttribute("userid");

        MemberInfoVo memberInfoVo=userService.getMemberInfo(id);
        model.addAttribute("memberinfo",memberInfoVo);
        return "user/memberinfo";
    }

    @RequestMapping({"/cancelmember"})
    public String cancelmember(HttpSession session){

       int id= (int) session.getAttribute("userid");
       userService.cancelmember(id);


        return "redirect:/user/userinfo";
    }

    @RequestMapping("/classinfo")
    public String classinfo(int id,Model model,HttpSession session) {

        ClassInfoVo classInfo =userService.getClassInfo(id);
        model.addAttribute("class",classInfo);

        return "user/classinfo";
    }

    @RequestMapping("/generateunchooseorder")
    public  String generateunchooseorder(int id, Model model,HttpSession session){
        if(session.getAttribute("userid")==null)
        {return "user/login";}
        else {
            int userid = (int) session.getAttribute("userid");

            OrderVo order = userService.generateordervo(id, userid);
            session.setAttribute("classid",id);
            model.addAttribute("order", order);
            return "user/generateunchooseorder";
        }

    }


    @RequestMapping("/generatechooseorder")
    public  String generatechooseorder(int id, Model model,HttpSession session){
        if(session.getAttribute("userid")==null)
        {return "user/login";}
        else {
            int userid = (int) session.getAttribute("userid");

            OrderVo order = userService.generateordervo(id, userid);
            session.setAttribute("classid",id);
            model.addAttribute("order", order);
            return "user/generatechooseorder";
        }

    }



    @RequestMapping(value = "/topayunchoose", method = RequestMethod.POST)
    public String topayunchoose(Model model,HttpSession session, @RequestParam("people") int people, @RequestParam("coupon") int coupon) {

        if(session.getAttribute("userid")==null||session.getAttribute("classid")==null)
        {return "user/login";}
        else{

            int userid = (int) session.getAttribute("userid");
            int classid=(int)session.getAttribute("classid");
            String orderid=userService.createunchooseorder(classid,userid,people,coupon);

            session.setAttribute("orderid",orderid);
            OrderEntity orderEntity=userService.getorderByid(orderid);
            session.setAttribute("totalprice",orderEntity.getTotalprice());
            model.addAttribute("order",orderEntity);
            return "user/topay";
        }


    }

    @RequestMapping(value = "/topaychoose", method = RequestMethod.POST)
    public String topaychoose(Model model,HttpSession session, @RequestParam("people") int people, @RequestParam("coupon") int coupon,@RequestParam("class") int classnum) {

        if(session.getAttribute("userid")==null||session.getAttribute("classid")==null)
        {return "user/login";}
        else{

            int userid = (int) session.getAttribute("userid");
            int classid=(int)session.getAttribute("classid");
            String orderid=userService.createchooseorder(classid,userid,classnum,people,coupon);

            session.setAttribute("orderid",orderid);
            OrderEntity orderEntity=userService.getorderByid(orderid);
            session.setAttribute("totalprice",orderEntity.getTotalprice());
            model.addAttribute("order",orderEntity);
            return "user/topay";
        }


    }


    @RequestMapping("/topay")
    public String topay(String orderid,Model model,HttpSession session) {

        session.setAttribute("orderid",orderid);
        OrderEntity orderEntity=userService.getorderByid(orderid);
        session.setAttribute("totalprice",orderEntity.getTotalprice());
        model.addAttribute("order",orderEntity);
        return "user/topay";
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String topay(HttpSession session,@RequestParam("password") String password){

        double totalprice= (double) session.getAttribute("totalprice");
        String bankaccount= (String) session.getAttribute("bankaccount");
        String orderid=(String)session.getAttribute("orderid");
        if(userService.pay(bankaccount,password,totalprice,orderid)==true){
            return "user/paysuccessfully";
        }

        return "redirect:/index";
    }


    @RequestMapping(value = "/exchangecoupon", method = RequestMethod.POST)
    public String exchangecoupon(HttpSession session,@RequestParam("point") int point){

        int userid= (int) session.getAttribute("userid");
        userService.exchangecoupon(userid,point);

        return "redirect:/user/memberinfo";
    }


    @RequestMapping(value = "/modifyinfo")
    public String showmodifyinfo(HttpSession session){

        return "user/modifyinfo";
    }


    @RequestMapping(value = "/showunpayorder")
    public String showunpayorder(HttpSession session,Model model){

        int userid= (int) session.getAttribute("userid");
        List<OrderEntity> unpayorders=userService.getunpayorder(userid);
        model.addAttribute("unpayorders",unpayorders);

        return "user/unpayorder";
    }

    @RequestMapping(value = "/showcancelorder")
    public String showcancelorder(HttpSession session,Model model){

        int userid= (int) session.getAttribute("userid");
        List<OrderEntity> cancelorders=userService.getcancelorder(userid);
        model.addAttribute("cancelorders",cancelorders);

        return "user/showcancelorder";
    }

    @RequestMapping(value = "/showpayedorder")
    public String showpayedorder(HttpSession session,Model model){

        int userid= (int) session.getAttribute("userid");
        List<OrderEntity> payedorders=userService.getpayedorder(userid);
        model.addAttribute("payedorders",payedorders);

        return "user/showpayedorder";
    }

    @RequestMapping(value = "/showsuccessorder")
    public String showsuccessorder(HttpSession session,Model model){

        int userid= (int) session.getAttribute("userid");
        List<OrderEntity> successorders=userService.getsuccessorder(userid);
        model.addAttribute("successorders",successorders);

        return "user/showsuccessorder";
    }


    @RequestMapping(value = "/showdrawbackorder")
    public String showdrawbackorder(HttpSession session,Model model){

        int userid= (int) session.getAttribute("userid");
        List<OrderEntity> drawbackorders=userService.getdrawbackorder(userid);
        model.addAttribute("drawbackorders",drawbackorders);

        return "user/showdrawbackorder";
    }


    @RequestMapping(value = "/modifyinfo", method = RequestMethod.POST)
    public String modifyinfo(HttpSession session,@RequestParam("name") String name,@RequestParam ("password") String password,@RequestParam("phone") String phone){

        int userid= (int) session.getAttribute("userid");
        userService.modifyinfo(userid,name,password,phone);

        return "redirect:/user/login";
    }



    @RequestMapping(value="/searchclass",method = RequestMethod.POST)
    public String searchclass(Model model,HttpSession session,@RequestParam("label") String label){

        List<ClassEntity> classlist=userService.searchclass(label);
        model.addAttribute("classes",classlist);
        model.addAttribute("label",label);
        return "user/classlist";

    }


    @RequestMapping("/searchclass")
    public String searchclass(String label,Model model,HttpSession session) {

        List<ClassEntity> classlist=userService.searchclass(label);
        model.addAttribute("classes",classlist);
        model.addAttribute("label",label);
        return "user/classlist";
    }


    @RequestMapping("/drawbackorder")
    public String drawbackorder(String orderid) throws ParseException {
        userService.drawbackorder(orderid);
        return "redirect:/user/showdrawbackorder";
    }



    @RequestMapping({"/", "/login" , "/index"})
    public String login() {
        return "user/login";
    }

    @RequestMapping("/register")
    public String register(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "user/register";
    }
}

