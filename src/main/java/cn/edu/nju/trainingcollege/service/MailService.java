package cn.edu.nju.trainingcollege.service;

import org.springframework.mail.SimpleMailMessage;


public interface MailService {

     void send (String to,String subject,String text);
}
